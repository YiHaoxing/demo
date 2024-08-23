package com.yihaoxing.demo.test.basic;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@SpringBootTest
public class LocalDateTest {
    @Test
    public void test01() {
        System.out.println(LocalDate.now().minus(3, ChronoUnit.YEARS));

        //2024-08-19
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate scopeStart = yesterday.minus(3, ChronoUnit.YEARS);
        System.out.println(scopeStart);
    }

    @Test
    public void test02() {
        System.out.println(LocalTime.parse("162912", DateTimeFormatter.ofPattern("HHmmss")).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
