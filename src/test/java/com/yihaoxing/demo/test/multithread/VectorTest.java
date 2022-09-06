package com.yihaoxing.demo.test.multithread;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Vector;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/8/12 15:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }

                }
            });
            removeThread.start();
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }

                }
            });
            printThread.start();
            while (Thread.activeCount() > 10) ;
        }
    }
}
