package com.yihaoxing.demo.test.basic;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/3 21:10
 */
public class Singleton {
    private static volatile Singleton singleton;

    /**
     * 构造方法私有化
     */
    private Singleton() {
        if (singleton != null) {
            throw new RuntimeException("单例对象只能创建一次");
        }
    }
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve(){
        return singleton;
    }
}
