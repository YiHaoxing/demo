package com.yihaoxing.demo.test.basic;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.googlecode.concurrentlinkedhashmap.Weighers;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yhx
 * @date 2020/9/29 15:18
 */
@SpringBootTest
public class ConcurrentLinkedHashMapTest {
    @Test
    public void test01() {
        //ConcurrentHashMap是线程安全的
        //LinkedHashMap是实现了LRU算法的
        //那么ConcurrentLinkedHashMap就是实现了LRU算法的线程安全的HashMap
        ConcurrentLinkedHashMap<Long, RateLimiter> map = new ConcurrentLinkedHashMap.Builder<Long, RateLimiter>()
                .maximumWeightedCapacity(2).weigher(Weighers.singleton())
                .build();
        map.put(1L, RateLimiter.create(1.0));
        map.put(2L, RateLimiter.create(1.0));
        System.out.println(map.get(1L));
        System.out.println(map.get(2L));
        System.out.println(map.get(1L));
        System.out.println(map.get(2L));
        map.put(3L, RateLimiter.create(1.0));
        System.out.println(JSON.toJSONString(map));
    }
}
