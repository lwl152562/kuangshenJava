package com.kuang.state;


import com.kuang.demo01.TestThread04;

//模拟网络延时，加大问题的发生性

public class TestSleep implements Runnable{
    //票数
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0){
                break;
            }
            //模拟延迟，出现了多个人抢到同一张票的情况
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- +"票");
        }
    }

    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();

        new Thread(ticket, "小明").start(); // 线程名字
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
    }
}
