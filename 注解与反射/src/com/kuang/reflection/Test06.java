package com.kuang.reflection;


//虚拟机先加载主类的方法
public class Test06 {
    static {
        System.out.println("Mainjiazai");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //反射也会产生主动引用
        //Class.forName("com.kuang.reflection.Son");

        //不会产生类的引用的方法
        //System.out.println(Son.b);

//        Son[] array = new Son[5];



    }

}

class Father{
    static int b = 2;

    static {
        System.out.println("父类被加载了");
    }
}

class Son extends Father{
    static {
        System.out.println("zi类被加载了");
        m = 300;
    }

    static int m = 100;
    static final int M=1;
}