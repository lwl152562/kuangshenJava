package com.kuang.state;


//测试守护线程
//上帝守护你

public class TestDeamon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false表示用户线程，正常的都是用户线程
        thread.start();

        new Thread(you).start();


    }
}


class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保有着你");
        }
    }
}


class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }

        System.out.println("=======goodbye=======");
    }
}
