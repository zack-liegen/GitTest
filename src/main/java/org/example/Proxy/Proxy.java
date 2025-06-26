package org.example.Proxy;

public class Proxy {
    public static void main(String[] args) {
        DateService service = new DateServiceProxy(new DateServiceImplA());
        service.add();
        service.del();
        DateService serviceB = new DateServiceProxy(new DateServiceImplBBB());
        serviceB.add();
        serviceB.del();
    }
}
//业务接口
interface DateService {
    void add();
    void del();
}

class DateServiceImplA implements DateService {
    @Override
    public void add() {
        System.out.println("成功添加！");
    }

    @Override
    public void del() {
        System.out.println("成功删除！");
    }
}
class DateServiceImplBBB implements DateService {
    @Override
    public void add() {
        System.out.println("成功添加BBB！");
    }

    @Override
    public void del() {
        System.out.println("成功删除BBB！");
    }
}

class DateServiceProxy implements DateService {
    DateService server;

    public DateServiceProxy(DateService server) {
        this.server = server;
    }
    @Override
    public void add() {
        server.add();
        System.out.println("程序执行add方法，记录日志.");
    }
    @Override
    public void del() {
        server.del();
        System.out.println("程序执行del方法，记录日志.");
    }
}


