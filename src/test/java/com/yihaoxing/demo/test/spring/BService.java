package com.yihaoxing.demo.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用于测试spring循环依赖
 *
 * @author yihaoxing
 * @since 2022/8/31 22:19
 */
@Component
public class BService {
    @Autowired
    private AService aService;

    @Transactional(rollbackFor = Exception.class)
    public void test(){
        System.out.println(aService);
    }
}
