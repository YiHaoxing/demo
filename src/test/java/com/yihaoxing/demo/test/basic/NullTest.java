package com.yihaoxing.demo.test.basic;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yhx
 * @date 2020/11/12 2:16 下午
 */
@SpringBootTest
public class NullTest {
    @Test
    public void test01(){
        Integer a = null;
        Integer b = 1;
        int c = 1;

        if(b.equals(a)){
            System.out.println("q");
        }

        if(null instanceof Integer){

        }

        if(b.equals(c)){
            System.out.println("q");
        }
    }

    @Test
    public void test06(){
        Integer a = null;
        Integer b = 1;
        int c = 1;
        // a == b 结果为false
        if(a == b){}
        // 这行代码会报空指针异常.因为Integer和基础数字比较时,会自动进行拆箱操作
        // 所以实际执行的代码是:a.intValue() == 1
        // 由于a = null,所以执行这行代码时就报空指针异常
        if(a == 1){}
        // 这行代码也会报空指针异常.原因同上
        if(a == c){}
    }

}
