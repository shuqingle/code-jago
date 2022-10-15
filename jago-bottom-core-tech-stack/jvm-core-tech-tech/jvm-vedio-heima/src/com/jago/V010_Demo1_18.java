package com.jago;

/**
 * 局部变量线程安全问题
 */
public class V010_Demo1_18 {
    //多个线程同时执行此方法，线程安全
    static void m1(){
        int x = 0;
        for (int i = 0; i < 5000; i++) {
            x++;
        }
        System.out.println(x);
    }
}
