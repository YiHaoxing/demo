package com.yihaoxing.demo.test.basic;

import lombok.Data;

/**
 * @author yhx
 * @date 2020/10/10 11:19
 */
@Data
public class Demo {
    String a;
    Integer b;

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);

        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1.length());
        System.out.println(s1 == s2);
    }
}
