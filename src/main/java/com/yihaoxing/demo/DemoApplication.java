package com.yihaoxing.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YiHaoxing
 * @date 2020/5/27 18:47
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yihaoxing.demo.sharding.dao")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
