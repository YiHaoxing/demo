package com.yihaoxing.demo.test.random;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomTest {

    @Test
    public void test02() {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 5) {
            int i = RandomUtils.nextInt(1, 9);
            set.add(i);
        }
        ArrayList<Integer> periods = new ArrayList<>(set);


        long l = 24315L % 8;
        System.out.println(l);
    }
}
