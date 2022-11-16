package com.jago;

/**
 * 演示类的初始化
 */
public class V147_Load3 {
    static {
        System.out.println("main init");
    }

    public static void main(String[] args) {
        //静态常量不会触发初始化

        //类对象.class不会触发初始化

        //创建类的数组不会发生初始化


    }
}

class V147_A{
    static int a = 0;
    static {
        System.out.println("a init");
    }
}

class V147_B extends V147_A{
    final static double b = 5.0;
    static boolean c = false;
    static {
        System.out.println("b init");
    }
}
