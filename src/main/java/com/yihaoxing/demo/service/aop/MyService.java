package com.yihaoxing.demo.service.aop;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@Service
public class MyService {
    public void processUser(User user) {
        // 方法逻辑
    }

    @MyAnnotation("#user.name") // 表达式 "#参数名.属性名"
    public void annotatedMethod(User user) {
        // 方法逻辑
    }

    @MyAnnotation("#age") // 直接获取基本类型参数
    public void processUser(Long id, String name, Integer age) {
        // 方法逻辑
    }

    @MyAnnotation("#user.name") // 获取对象参数的属性
    public void updateUser(User user, Integer age) {
        // 方法逻辑
    }

    @MyAnnotation("#address.city") // 获取嵌套对象的属性
    public void saveAddress(User user, Address address) {
        // 方法逻辑
    }

    @PostConstruct
    public void init() {
        System.out.println("MyService已初始化，说明已注入容器");
    }
}
