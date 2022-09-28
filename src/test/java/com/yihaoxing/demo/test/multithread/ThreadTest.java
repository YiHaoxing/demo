package com.yihaoxing.demo.test.multithread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/9/18 01:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadTest {

    @Test
    public void test01(){
        ThreadDemo threadDemo = new ThreadDemo("thread-1");
        threadDemo.run();
        threadDemo.start();
    }
}
