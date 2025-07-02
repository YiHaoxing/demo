package com.yihaoxing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author YiHaoxing
 * @date 2020/5/27 18:47
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
