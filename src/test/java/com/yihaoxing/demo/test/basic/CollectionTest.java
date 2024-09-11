package com.yihaoxing.demo.test.basic;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@SpringBootTest
public class CollectionTest {

    @Test
    public void test01() {
        Demo demo = new Demo();
        demo.setA(null);
        demo.setB(5);
        Demo demo2 = new Demo();
        demo2.setA("a");
        demo2.setB(2);
        Demo demo3 = new Demo();
        demo3.setA(null);
        demo3.setB(3);
        List<Demo> demos = Lists.newArrayList(demo, demo2, demo3);
        Map<String, Demo> map = demos.stream().collect(Collectors.toMap(Demo::getA, Function.identity(), (k1, k2) -> k1));
        System.out.println(map.get(null).getB());
    }
}
