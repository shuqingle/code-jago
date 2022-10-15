package com.jago;

/**
 * 线程死锁
 */
public class V015_Demo1_3 {
    static A a = new A();
    static B b = new B();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (a){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("获取了a和b");
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            synchronized (b){
                synchronized (a){
                    System.out.printf("获取了a和b");
                }
            }
        }).start();
    }
}

class A{

}
class B{

}
