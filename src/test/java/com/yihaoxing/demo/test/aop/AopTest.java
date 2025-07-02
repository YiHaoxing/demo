package com.yihaoxing.demo.test.aop;

import com.yihaoxing.demo.service.aop.Address;
import com.yihaoxing.demo.service.aop.MyService;
import com.yihaoxing.demo.service.aop.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@SpringBootTest
@EnableAspectJAutoProxy
@RunWith(SpringRunner.class)
public class AopTest {
    @Autowired
    private MyService myService;

    @Test
    public void test01() {
        User user = new User();
        user.setName("<UNK>");
        //myService.annotatedMethod(user);

        //myService.processUser(1L,"ABC",999);

        Address address = new Address("杭州");
        myService.saveAddress(user, address);

    }
}
