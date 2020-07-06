package com.yihaoxing.demo.test.basic;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YiHaoxing
 * @date 2020/7/6 10:33
 */
@SpringBootTest
public class IntegerTest {
    @Test
    public void test01(){
        Integer a1 = new Integer(10);
        Integer a2 = new Integer(10);
        System.out.println(a1 == a2);//比较的是地址
        System.out.println(a1.equals(a2));//Integer类的equals方法是取值其内部int值进行比较的
    }
    @Test
    public void test02(){
        //Integer a = xx; 这种形式的赋值写法，其实编译后是通过调用Integer.valueOf()来创建对象和赋值的
        //查看valueOf源码可以发现从-128~127是从IntegerCache里获取的，所以a1和a2地址是一样的
        Integer a1 = 10;
        Integer a2 = 10;
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
    }
    @Test
    public void test03(){
        //200超过了-128~127的范围，所以a1和a2都是新建的对象，此时地址不一样
        Integer a1 = 200;
        Integer a2 = 200;
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
    }
    @Test
    public void test04(){
        //结果为true，这里会有一些疑惑，因为a1和a2压根就不是一种类型，为什么是true？==不是比较地址吗？
        //这里通过查看字节码可以发现原因，实际执行时，这里的==其实是这样执行的：a1 == a2.intValue();
        //[其实可以理解为JVM执行或者编译的一种优化，这里会自动对Integer拆箱取其int值，因为我们写这行代码的目的就是想比较其int值是否相等的；不然的话，如果是比较地址，不论其数值是否相等，a1 == a2永远都是false，那么这行代码是没有意义的]
        //会先取出包装类型Integer的int值，然后进行比较，因此结果就是true
        int a1 = 10;
        Integer a2 = 10;
        System.out.println(a1 == a2);
        //这里结果也为true，Integer的equals方法如下
        /**
         *     public boolean equals(Object obj) {
         *         if (obj instanceof Integer) {
         *             return value == ((Integer)obj).intValue();
         *         }
         *         return false;
         *     }
         */
        //如果按照代码来看，obj instanceof Integer的结果应该为false，但是实际运行的结果是true，这里是因为自动装箱操作，将int包装成Integer类型了
        System.out.println(a2.equals(a1));
    }
    @Test
    public void test05(){
        //a1是从IntegerCache中取的对象，b1是通过new新建的对象
        //a2和b2是通过new调用构造方法新建的对象，是一块新的地址空间
        //那么a1和a2，b1和b2的地址一定是不相同的，此时==比较地址就为false
        Integer a1 = 10;
        Integer a2 = new Integer(10);
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));


        Integer b1 = 200;
        Integer b2 = new Integer(200);
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }

    /**
     * 其实核心的点就是，==比较地址，equals比较内部的int数值
     * new Integer(x)这种一定是新建对象，会新分配内存地址
     * Integer a = xx; 这种其实就是一种语法糖，编译后还是用valueOf()方法；
     * valueOf()方法中，如果数组在-128~127范围内，则直接从内部的一个缓存中取一个对象，如果不在这个范围，则直接调用new Integer(x)创建一个新对象
     *
     * 还有一个比较特殊的，int和Integer类型的比较，这里涉及到自动拆箱、封箱
     * 例如Integer a; int b;
     * a==b 比较时，a会自动拆箱，取a.intValue和b进行比较
     * a.equals(b) 比较时，b会自动装箱，变为Integer类型，然后equals比较
     * 所以可以看出，int和Integer类型实际上都是比较的数值，而不是地址
     *
     * 总之，int和Integer比较的规则就上边这几点，熟悉掌握，然后大部分的面试问题就可以应付（万变不离其宗）
     */
}
