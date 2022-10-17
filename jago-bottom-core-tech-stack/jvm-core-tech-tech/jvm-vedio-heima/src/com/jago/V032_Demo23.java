package com.jago;

public class V032_Demo23 {
    public static void main(String[] args) {

        String s = new String("a") + new String("b");
        //内存分析：
        //串池：["a","b"]
        //堆：new String("a"),new String("b"),new String("ab");
        String s2 = s.intern();
        //将new的字符串对象（放堆中的）尝试放入串池，如果有则不会放入，如果没有则放入串池，会把串池中的对象返回
        //串池：["a","b","ab"]
//        System.out.println(s2 == "ab");//true
//        System.out.println(s2 == s);//s已经被放入串池，所以指的是同一个对象
//
        System.out.println(s2 == s);//true
        String x1 = "ab";
        String x = new String("a") + new String("b");
        String x2 = x.intern();
        System.out.println(x == x2);//false
    }
}
