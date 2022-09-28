package com.yihaoxing.demo.test.multithread;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/9/18 01:36
 */
public class ThreadDemo extends Thread{

    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}
