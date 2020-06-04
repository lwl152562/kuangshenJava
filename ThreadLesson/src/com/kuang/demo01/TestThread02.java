package com.kuang.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.DataTruncation;

//联系Thread，实现多线程同步下载图片
public class TestThread02 extends Thread{

    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestThread02(String url, String name){  // 此处可以用TT2（快捷方式）快速生成
        this.url = url;
        this.name = name;
    }


    //下载图片线程的执行体
    @Override
    public void run() {
        WebDonloader webDonloader = new WebDonloader();
        webDonloader.downloader(url, name);
        System.out.println("下载好了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588521435447&di=8c15a8cd61dcf7bc6b7dca719b5b974a&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg", "1.jpg");
        TestThread02 t2 = new TestThread02("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588521710716&di=43535ff448177e5bd21ae891e887b4e5&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D2247852322%2C986532796%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1280%26h%3D853", "2.jpg");
        TestThread02 t3 = new TestThread02("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588521756730&di=214905821e9be9a1d5b605f3e9f986ce&imgtype=0&src=http%3A%2F%2Ft9.baidu.com%2Fit%2Fu%3D3363001160%2C1163944807%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1280%26h%3D830", "3.jpg");

        //是同时执行的，结果不一定相同
        t1.start();
        t2.start();
        t3.start();
    }

}

//下载器
class WebDonloader{
    //下载方法
    public void downloader(String url, String name){  //  下载图片的地址及下载至本地设置的文件名
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader出现问题");
        }
    }
}