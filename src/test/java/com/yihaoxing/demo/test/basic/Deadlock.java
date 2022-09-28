package com.yihaoxing.demo.test.basic;

import lombok.SneakyThrows;

import java.util.ArrayList;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/9/18 18:34
 */
public class Deadlock {

    public Integer a = 1024;
    public int b = 1024;

    public static final String LOCK_A = "A";
    public static final String LOCK_B = "B";

    public static void main(String[] args) {
        ArrayList<Demo> list = new ArrayList<>();
        while (true) {
            Demo demo = new Demo();
            demo.setA("获取到锁A获取到锁A获取到锁A获取到锁A获取到锁A获取到锁A获取到锁A获取到锁A获取到锁A" + list.size());
            list.add(demo);
            System.out.println(list.size());
        }
    }


    private static void extracted() {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (LOCK_A) {
                    System.out.println("当前线程:" + Thread.currentThread() + "  获取到锁A,准备获取锁B");
                    Thread.sleep(2000);
                    synchronized (LOCK_B) {
                        System.out.println("当前线程:" + Thread.currentThread() + "  获取到锁B");
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK_B) {
                    System.out.println("当前线程:" + Thread.currentThread() + "  获取到锁B,准备获取锁A");
                    synchronized (LOCK_A) {
                        System.out.println("当前线程:" + Thread.currentThread() + "  获取到锁A");
                    }
                }

            }
        }).start();
    }
}
