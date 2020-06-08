package com.kuang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {

    //注解可以显示赋值，如果没有默认值，就必须给注释赋值
    @MyAnnotation2(name = "kuangshen", schools = {"CUP"})//注解没有顺序
    public void test(){

    }

    @MyAnnotation3("") // 如果是value，可以不加名称
    public void test2(){

    }

}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名()；
    String name() default  "";//不是方法,默认为空
    int age() default 0;
    int id() default -1;//如果默认值为-1代表不存在，indexof如果找不到就返回-1

    String[] schools() default  {"某某大学", "XX大学"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}