package com.jago;

import java.io.IOException;

/**
 * 分析解析的含义
 */

public class V146_Load2 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = V146_Load2.class.getClassLoader();
        //loadclass只会导致V146_C的加载，并不会导致V146_C类的解析和初始化，从而类V146_D也不会加载和初始化
        //运行成功后通过HSDB查看类C和类D是否被成功加载
        //HSDB查看进程时发现类D被标识为：JVM_CONSTANT_UnresolvedClass(未被解析)
//        Class<?> C = classLoader.loadClass("com.jago.V146_C");
        //new V146_C()会加载解析和初始化，从而V146_D也会加载解析和初始化
        //HSDB查看进程时发现类D和C都被加载解析和初始化了
        new V146_C();
        System.in.read();

    }
}

class V146_C{
    V146_D d = new V146_D();
}

class V146_D{

}
