package com.jago;

/**
 * 利用类加载，完成懒惰初始化单例模式
 * 保证jvm类实例对象就一个
 * 线程安全：因为类加载器调用初始化的，线程保证安全
 */
public class V149_Singleton {
    private V149_Singleton(){}

    public static void test(){
        System.out.println("test");
    }

    private static  class LazyHolder{


        //final就一份不给改
        //静态内部类可以访问外部类的私有构造
        static final V149_Singleton INSTANCE = new V149_Singleton();
        static {
            System.out.println("lazy holder init");
        }
    }

    public static V149_Singleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        V149_Singleton.test();//lazy不会初始化
        V149_Singleton.getInstance();//第一次调用时才会触发初始化
        V149_Singleton.getInstance();
    }
}
