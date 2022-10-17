//package com.jago;
//
//import jdk.internal.org.objectweb.asm.ClassWriter;
//import jdk.internal.org.objectweb.asm.Opcodes;
//
///**
// * 演示元空间内存溢出
// */
//public class V023_Demo1_8 extends ClassLoader {
//    public static void main(String[] args) {
//        int j = 0;
//        try {
//            V023_Demo1_8 test = new V023_Demo1_8();
//            for (int i = 0; i < 10000; i++,j++) {
//                //ClassWriter是用代码的方式来生成类的字节码
//                ClassWriter cw = new ClassWriter(0);
//                //参数解析：jdk1.8,public,类名，包名，父类，接口
//                cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
//                byte[] code = cw.toByteArray();
//                //使用类加载器加载触发类的加载，生成class对象
//                test.defineClass("Class"+i,code,0,code.length);
//            }
//        } finally {
//            System.out.println(j);
//        }
//    }
//}
