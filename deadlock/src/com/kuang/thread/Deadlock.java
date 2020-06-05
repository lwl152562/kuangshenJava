package com.kuang.thread;

public class Deadlock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick{}

//镜子

class Mirror{}

//化妆
class Makeup extends Thread{
    
    //需要的资源只有一份，用static来保证的只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    
    int choice;//选择
    String girlName;// 使用化妆品的人
    
    Makeup(int choice, String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice == 0){
            synchronized (lipstick){//获得口红的锁
                System.out.println(this.girlName + "获得口红的锁");
                Thread.sleep(1000);
//死锁形成               synchronized (mirror) {//1秒钟后想获得镜子
//死锁形成                 System.out.println(this.girlName + "获得镜子的锁");
//死锁形成                }
            }synchronized (mirror) {//1秒钟后想获得镜子
                System.out.println(this.girlName + "获得镜子的锁");//将锁放在外面，就不会死锁
            }
        }else {
            synchronized (mirror){//镜子的锁
                System.out.println(this.girlName + "获得镜子的锁");
                Thread.sleep(2000);


            }synchronized (lipstick) {//1秒钟后想获得口红
                System.out.println(this.girlName + "获得口红的锁");
            }

        }
    }
    
}