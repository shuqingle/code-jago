package com.jago;

/**
 * 语法糖-可变参数
 */
public class V134_Candy4 {
    public static void  foo(String... args){
        String[] array = args;
        System.out.println(array);
    }
    public static void main(String[] args) {
//        foo("stt","zyy");
        foo(new String[]{"stt","zyy"});
    }
}
