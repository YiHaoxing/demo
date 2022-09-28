package com.yihaoxing.demo.test.serialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class B2 extends B1 implements Serializable {
    private static final long serialVersionUID = 7010568907049187737L;

    private String desc;
    private Date date;

    static ThreadLocal<User> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tl.set(new User());
        }).start();
    }
}
