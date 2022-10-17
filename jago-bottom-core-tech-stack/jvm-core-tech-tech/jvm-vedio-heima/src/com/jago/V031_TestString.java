package com.jago;

/**
 * 延迟实例化
 * 通过idea的memory控制台的Loadclass,查看断点过程中String的个数
 */
public class V031_TestString {
    public static void main(String[] args) {
        int x = args.length;
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
    }
}
