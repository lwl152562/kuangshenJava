package com.kuang.syn;

//不安全的取钱
//两个人去银行，账户

public class UnsafeBank {
    public static void main(String[] args) {


        //账户
        Account account = new Account(100, "结婚基金");

        Drawing you = new Drawing(account,50, "你");
        Drawing girlFriend = new Drawing(account,100, "girlFriend");

        you.start();
        girlFriend.start();

    }
}


//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行:模拟取款
class Drawing extends Thread{


    Account account;//账户

    int drawingMoney;//取了多少钱

    int nowMoney;//还有多少钱

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.drawingMoney = drawingMoney;
        this.account = account;

    }

    //取钱

    @Override
    public void run() {
        //判断有没有钱
        if (account.money - drawingMoney < 0 ){
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //卡内余额
        account.money = account.money - drawingMoney;
        //手里的钱
        nowMoney = nowMoney + drawingMoney;

        System.out.println(account.name + "余额为" + account.money);
        //Thread.currentThread.getName = this.getName
        System.out.println(this.getName() + "手里的钱" + nowMoney);
    }
}
