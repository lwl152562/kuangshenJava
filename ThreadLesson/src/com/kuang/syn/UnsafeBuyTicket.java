package com.kuang.syn;


//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();


        new Thread(station, "苦逼的我").start();
        new Thread(station, "牛逼的你们").start();
        new Thread(station, "可恶的黄牛党").start();
    }
}


class BuyTicket implements Runnable{

    private int ticketNums = 10;
    private boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //synchronized 同步方法，锁的是this
//    private void buy() throws InterruptedException {
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <= 0){
            flag = false;
            return;
        }

        //模拟延时
        Thread.sleep(100);

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}