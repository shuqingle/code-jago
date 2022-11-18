package com.jago;

/**
 * 演示类的初始化
 */
public class V147_Load3 {
    static {
        System.out.println("main init");
    }
    //main方法执行后类总会被初始化
    public static void main(String[] args) throws ClassNotFoundException {
        //静态常量不会触发初始化
//        System.out.println(V147_B.b);//b的静态代码块没执行
        //类对象.class不会触发初始化
//        System.out.println(V147_B.class);//加载阶段生成了Mirror，初始化阶段不会
        //创建类的数组不会发生初始化
//        System.out.println(new V147_B[0]);
        //ClassLoader不会初始化类B，但是会加载B,A
//        ClassLoader c1 = Thread.currentThread().getContextClassLoader();
//        c1.loadClass("com.jago.V147_Load3");
        //ClassForname第二个参数为false时不会初始化类B，但是会加载B,A
//        ClassLoader c2 = Thread.currentThread().getContextClassLoader();
//        Class.forName("com.jago.V147_Load3",false,c2);

        //首次访问这个类的静态变量和静态方法时,会初始化
//        System.out.println(V147_A.a);
        //子类初始化，如果父类还没初始化会引发
        System.out.println(V147_B.c);
        //子类访问父类的静态变量,只会触发父类的初始化，子类不会初始化
        System.out.println(V147_B.a);
        //ClassForname不传参数,A和B都初始化
        Class.forName("com.jago.V147_Load3");
    }
}

class V147_A{
    static int a = 0;
    static {
        System.out.println("a init");
    }
}

class V147_B extends V147_A{
    static {
        System.out.println("b init");
    }
    final static double b = 5.0;
    static boolean c = false;

}
