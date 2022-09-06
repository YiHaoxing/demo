package com.yihaoxing.demo.test.basic;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yhx
 * @date 2020/8/24 11:51
 */
@SpringBootTest
public class StringTest {

    @Test
    public void test01() {
        String s = new String("ff");
        System.out.println(s.equals(null));
    }


    @Test
    public void test03() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.values());
    }

    @Test
    public void test04() {
        ArrayList<String> list = new ArrayList<>();
        list.add("$abadf");
        list.add("abadf$");
        list.add("abadf$$");
        list.add("aba$d");
        list.add("abadf123,;;");
        String join = String.join("$$", list);
        System.out.println(join);


        String[] s = join.split("\\$\\$");

    }

    @Test
    public void test05() {
        ArrayList<String> list = new ArrayList<>();
        list.add("$abadf");
        list.add("abadf$");
        list.add("abadf$$");
        list.add("aba$d");
        list.add("abadf123,;;");
        A a = new A();
        a.setStrings(list);
        B b = new B();
        BeanUtils.copyProperties(a, b);
        System.out.println(b.getStrings());


        Integer t = null;
        if (t == 1) {
            System.out.println(t);
        }
    }

    @Data
    public static class Demo {
        String a;
        Integer b;
    }

    @Test
    public void test06() {
        ArrayList<Demo> list = new ArrayList<>();

        Demo demo = new Demo();
        demo.setA(null);
        demo.setB(1);

        Demo demo2 = new Demo();
        demo2.setA("2");
        demo2.setB(null);

        Demo demo3 = new Demo();
        demo3.setA("3");
        demo3.setB(1);

        list.add(demo);
        list.add(demo2);
        list.add(demo3);

        Map<String, List<Demo>> collect = list.stream().collect(Collectors.groupingBy(Demo::getA));

    }


    @Test
    public void test08() {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        System.out.println(i);
        System.out.println(j);
        System.out.println(i + j);
    }


    @Test
    public void test09() {
        new HashMap<String, String>();
        System.out.println(test());
    }

    public int test() {
        Demo[] demos = new Demo[10];
        HashSet<Integer> hashSet = new HashSet<>();
        int a = 1;
        try {
            return a;
        } finally {
            a = 2;
            return a;
        }
    }

    @Test
    public void test10() {
        ArrayList<String> userNames = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
            add("d");
        }};
        for (String userName : userNames) {
            if (userName.equals("b")) {
                userNames.remove(userName);
            }
        }
        System.out.println(userNames);
    }
}
