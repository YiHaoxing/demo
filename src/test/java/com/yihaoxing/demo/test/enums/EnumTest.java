package com.yihaoxing.demo.test.enums;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class EnumTest {

    @Test
    public void test01() throws InterruptedException {
        Boolean a = null;
        if(true != a){
            System.out.println("h");
        }
        if(!a){
            System.out.println("h");
        }
    }


    @Test
    public void test02() throws InterruptedException {
        Integer a = 10;
        Integer b = 19999;
        System.out.println(check((long) b - a));
    }

    public long check(long i){
        return i;
    }


    @Test
    public void test03(){
        A a = new A();
        a.setAppTypeEnum(AppTypeEnum.ANDROID);

        String s = JSON.toJSONString(a);
        B b = JSON.parseObject(s, B.class);

        String s1 = JSON.toJSONString(AppTypeEnum.ANDROID);
        AppTypeEnum appTypeEnum = JSON.parseObject(s1, AppTypeEnum.class);

    }

    public static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test04() throws JsonProcessingException {
        A a = new A();
        a.setAppTypeEnum(AppTypeEnum.ANDROID);

        String s2 = objectMapper.writeValueAsString(a);

        B b = objectMapper.readValue(s2, B.class);
    }
}
