package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获得Class对象
        Class c1 = Class.forName("com.kuang.reflection.User");

        //构造一个对象
        User user = (User)c1.newInstance();  //本质上是调用了类的无参构造器，如果没有无参构造就不成功
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("kuangshen", 001, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class/*传入一个参数*/);
        //invoke:激活
        setName.invoke(user3, "kuangshenshuo");//反射获取方法
        System.out.println(user3.getName());;

        //通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);//取消private权限检测
        name.set(user4, "kuangshen2");
        System.out.println(name.getName());


    }
}
