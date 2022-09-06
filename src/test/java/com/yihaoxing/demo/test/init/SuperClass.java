package com.yihaoxing.demo.test.init;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/24 17:54
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}
