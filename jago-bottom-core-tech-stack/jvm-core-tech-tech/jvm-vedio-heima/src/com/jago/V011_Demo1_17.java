package com.jago;

public class V011_Demo1_17 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        new Thread(()->{
            m2(sb);
        }).start();
    }

    /**
     * m1方法线程安全--sb是线程的局部变量
     */
    public static void m1(){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        System.out.println(sb.toString());
    }

    /**
     * m2存在线程安全问题--sb是方法参数,有可能有其他线程访问到这个sb,对多个线程是
     * 共享的
     * @param sb
     */
    public static void m2(StringBuilder sb){
        sb.append("1");
        System.out.println(sb.toString());
    }

    /**
     *  变量逃离了方法作用范围，虽然是局部变量，但是依旧不是线程安全
     * @return
     */
    public static StringBuilder m3(){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        return sb;
    }
}
