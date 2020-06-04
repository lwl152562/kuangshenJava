//代理模式可以解释线程的实现原理，解释Runnable是如何通过Thread实现的


//静态代理模式总结：
//真实对象和代理对象都要实现同一个接口

//好处：代理对象可以做很多真实对象做不了的事情
//真实对象可以专注做自己的事情

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();//你要结婚

        new Thread( () -> System.out.println("我爱你")).start();


        new WeddingCompany(new You()).HappyMarry();

//        WeddingCompany weddingCompany = new WeddingCompany(you);
//        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//You是真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("xxx结婚了");
    }
}

//代理角色，帮助结婚
class WeddingCompany implements Marry{


    //代理->真实目标角色
    private Marry target;//代理对象要代理真实角色

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {

        before();
        this.target.HappyMarry();
        after();

    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");
    }
}