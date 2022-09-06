package com.yihaoxing.demo.test.init;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/24 18:10
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLO_WORLD = "hello world";
    static {
        i = 0;
    }
    static int i= 1;
    static {
        i = 2;
    }
}
