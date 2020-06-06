package com.kuang.annotation;


import java.lang.annotation.*;


//测试元注解
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test(){

    }
}


//定义一个注解
//Target表示注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//retention  表示注解在什么地方还有效  runtime > calss > sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documented表示是否将我们的注解生成在JAVAdoc中
@Documented

//子类可以继承父类的注解
@Inherited

@interface MyAnnotation{

}