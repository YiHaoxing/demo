package com.yihaoxing.demo.test.serialize;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yihaoxing.demo.test.enums.A;
import com.yihaoxing.demo.test.enums.AppTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SerializeTest {

    @Test
    public void test01() throws FileNotFoundException {

        A2 a2 = new A2();
        a2.setId(1L);
        a2.setDate(new Date());
        a2.setDesc("sss");

        //bean拷贝
        B2 b2 = new B2();
        BeanUtils.copyProperties(a2, b2);
        System.out.println(JSON.toJSONString(b2));

        //JSON序列化
        String s = JSON.toJSONString(a2);
        B2 b21 = JSON.parseObject(s, B2.class);
        System.out.println(JSON.toJSONString(b21));

    }

    //序列化
    @Test
    public void test02() {

        A2 a2 = new A2();
        a2.setId(1L);
        a2.setDate(new Date());
        a2.setDesc("sss");

        System.out.println(JSON.toJSONString(a2));

        FileOutputStream out;
        ObjectOutputStream oout;
        try {
            out = new FileOutputStream("Test1.txt");//子类序列化
            oout = new ObjectOutputStream(out);
            oout.writeObject(a2);
            oout.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //反序列化
    @Test
    public void test03() {
        FileInputStream in;
        ObjectInputStream oin;
        try {
            in = new FileInputStream("Test1.txt");
            oin = new ObjectInputStream(in);
            A2 a2 = (A2) oin.readObject();
            System.out.println(JSON.toJSONString(a2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void test04() {

        FileOutputStream out;
        ObjectOutputStream oout;
        FileInputStream in;
        ObjectInputStream oin;
        try {

            A a = new A();
            a.setAppTypeEnum(AppTypeEnum.ANDROID);

            out = new FileOutputStream("enum.txt");//子类序列化
            oout = new ObjectOutputStream(out);
            oout.writeObject(a);
            oout.close();

            in = new FileInputStream("enum.txt");
            oin = new ObjectInputStream(in);
            A a2 = (A) oin.readObject();
            System.out.println(JSON.toJSONString(a2));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static final ObjectMapper objectMapper= new ObjectMapper();
    @Test
    public void test05() throws JsonProcessingException {
        float value = 241.51614612f;
        System.out.println(Float.toString(value));

        ArrayList<Long> list = new ArrayList<>();
        list.add(214L);
        list.add(122127408L);
        System.out.println(objectMapper.writeValueAsString(list));
    }


    /**
     * 测试循环依赖的对象使用jdk序列化会不会报错
     * 如果没有重写toString、hashCode这些方法（因为这些方法会用到循环引用的对象），是不会报错的
     * 所以jdk的序列化方式，就是类信息+数据的地址，他不会去遍历每个类变量，所以就不会导致序列化和反序列化时栈内存溢出
     *
     * 如果加上toString、hashCode这些方法，或者使用json的序列化方式，就会有栈内存溢出的问题
     */
    @Test
    public void test06() {

        FileOutputStream out;
        ObjectOutputStream oout;
        FileInputStream in;
        ObjectInputStream oin;
        try {

            C parent = new C();
            parent.setS("fff");

            C child = new C();
            child.setS("abc");
            child.setParent(parent);
            parent.setChild(child);

            out = new FileOutputStream("c1.txt");//序列化
            oout = new ObjectOutputStream(out);
            oout.writeObject(parent);
            oout.close();

            in = new FileInputStream("c1.txt");
            oin = new ObjectInputStream(in);
            C c11 = (C) oin.readObject();
            System.out.println(c11.getChild().getS());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
