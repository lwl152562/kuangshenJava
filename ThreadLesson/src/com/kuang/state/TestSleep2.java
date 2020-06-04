package com.kuang.state;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestSleep2 {
    public static void main(String[] args) {
        //打印当前系统时间
        Date starttime = new Date(System.currentTimeMillis());

        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(starttime));
                starttime = new Date(System.currentTimeMillis());// 获取当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }



    //模拟倒计时
    public static void tenDown() throws InterruptedException{
        int num = 10;

        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num == 0){
                break;
            }
        }
    }
}
