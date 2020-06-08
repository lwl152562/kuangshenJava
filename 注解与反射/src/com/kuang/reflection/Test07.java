package com.kuang.reflection;

import javafx.application.Application;

public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException {


        //1.获取系统的类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器（C/C++），Java得不到这一层
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是那个加载器加载的
        ClassLoader classLoader = Class.forName("com.kuang.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器的录井

        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制
//        java.lang.String-->
        /*
        D:\java\jdk1.8.0_201\jre\lib\charsets.jar;
        D:\java\jdk1.8.0_201\jre\lib\deploy.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\localedata.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\sunec.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;
        D:\java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;
        D:\java\jdk1.8.0_201\jre\lib\javaws.jar;
        D:\java\jdk1.8.0_201\jre\lib\jce.jar;
        D:\java\jdk1.8.0_201\jre\lib\jfr.jar;
        D:\java\jdk1.8.0_201\jre\lib\jfxswt.jar;
        D:\java\jdk1.8.0_201\jre\lib\jsse.jar;
        D:\java\jdk1.8.0_201\jre\lib\management-agent.jar;
        D:\java\jdk1.8.0_201\jre\lib\plugin.jar;
        D:\java\jdk1.8.0_201\jre\lib\resources.jar;
        D:\java\jdk1.8.0_201\jre\lib\rt.jar;
        C:\Users\wang\Desktop\kuangshenJava\out\production\注解与反射;
        D:\IntelliJ IDEA 2020.1\lib\idea_rt.jar
         */
    }
}
