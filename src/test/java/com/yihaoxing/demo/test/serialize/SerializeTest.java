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


}
