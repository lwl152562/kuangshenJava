package com.kuang.reflection;


import java.lang.annotation.Inherited;

//测试class类的创建方式
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是"+person.name);

        //1.通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //2.forname获得
        Class c2 = Class.forName("com.kuang.reflection.Student");
        System.out.println(c2.hashCode());

        //3.通过类名.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //4.每个包都有个Type类
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    String name;


    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}