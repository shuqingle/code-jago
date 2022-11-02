package com.jago;

/**
 * 图解方法执行流程
 * 演示 字节码指令和操作数栈，常量池关系
 */
public class V109_Demo3_1 {
    public static void main(String[] args) {
        int a = 10;
        int b = Short.MAX_VALUE+1;
        int c = a+b;
        System.out.println(c);
    }
}
