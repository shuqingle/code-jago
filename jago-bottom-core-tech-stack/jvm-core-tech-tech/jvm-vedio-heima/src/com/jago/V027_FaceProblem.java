package com.jago;

/**
 * stringtable面试题
 */
public class V027_FaceProblem {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a"+"b";
        String s4 = s1+s2;//new String("ab")
        String s5= "ab";
        String s6 = s4.intern();

        System.out.println(s3==s4);//false
        System.out.println(s3==s5);//true
        System.out.println(s3==s6);//true

//        String x2 = new String("c") + new String("d");
//        String x1 = "cd";
//        x2.intern();
//        //问：如果调换了最后两行代码的位置呢？如果是jdk1.6呢？
//        System.out.println(x1 == x2);//false;

        String x1 = "cd";
        String x2 = new String("c") + new String("d");
        x2.intern();
        //问：如果调换了最后两行代码的位置呢？如果是jdk1.6呢？
        System.out.println(x1 == x2);//true;

    }
}
