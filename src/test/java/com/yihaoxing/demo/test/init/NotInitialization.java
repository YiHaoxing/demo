package com.yihaoxing.demo.test.init;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/24 17:56
 */

import com.yihaoxing.demo.test.basic.A;

/**
 * 常量在编译阶段会存入调用类的常量池中,本质上没有直接引用到定义常量的类,因此不会触发定义常量的类的初始化
 */
public class NotInitialization {
    public static void main(String[] args) {

        Class<A> aClass = A.class;

        System.out.println(ConstClass.HELLO_WORLD);
        System.out.println(ConstClass.i);
    }
}
