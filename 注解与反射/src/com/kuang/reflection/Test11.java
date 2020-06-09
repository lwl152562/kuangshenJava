package com.kuang.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test11 {

    public void test01(Map<String, User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String, User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", List.class);

        Type[] genericExceptionTypes = method.getGenericExceptionTypes();
        for (Type genericExceptionType : genericExceptionTypes) {
            System.out.println("#"+genericExceptionType);
            if(genericExceptionType instanceof ParameterizedType){
                //没打完，感觉没必要
            }
        }

    }
}
