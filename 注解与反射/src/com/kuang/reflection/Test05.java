package com.kuang.reflection;

import com.sun.org.glassfish.external.statistics.impl.StatisticImpl;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /*
        1.加载到内存。产生一个类对应Class对象
        2.链接，结束后m=0
        3.初始化：

         */

    }
}

class A{
    static {
        System.out.println("A类的静态代码块和初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
