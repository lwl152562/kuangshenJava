
//主要理解1,该Java文档主要是用于说明带参数的lambda表达式

//lambda表达式只有一行代码的情况下才能简写成一行，如果有多行需要写成代码块

package com.kuang.lambda;

public class TestLambda2 {

    public static void main(String[] args) {
        ILove love = null;

        love = a -> System.out.println("i love you "+a);

        love.love(521);

    }
}

interface ILove{
    void love(int a);
}


class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("i love you1");
    }
}