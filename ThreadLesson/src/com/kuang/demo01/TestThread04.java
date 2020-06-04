package com.kuang.demo01;


//多个线程同时操作一个对象
public class TestThread04 implements Runnable{

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
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- +"票");
        }
    }

    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();

        new Thread(ticket, "xiaoming").start();
        new Thread(ticket, "laoshi").start();
        new Thread(ticket, "huangniu").start();
    }
}
