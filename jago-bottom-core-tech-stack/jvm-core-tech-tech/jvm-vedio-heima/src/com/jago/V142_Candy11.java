package com.jago;

/**
 * 匿名内部类语法糖
 */
public class V142_Candy11 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
    }
    //当匿名内部类引用了final变量时
    public static void test(final int x){
        Runnable runnable = new Candy11$2(x);
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("ok:"+x);
//            }
//        };

    }
}

//额外生成的类
final class Candy11$1 implements Runnable{
    Candy11$1(){

    }
    @Override
    public void run() {
        System.out.println("ok");
    }
}

//test方法额外生成的类
final class Candy11$2 implements Runnable{
    int val$x;
    Candy11$2(int x){
        this.val$x = x;
    }
    @Override
    public void run() {
        System.out.println("ok:"+this.val$x);
    }

}