package com.jago;

import java.io.IOException;

/**
 * 演示多态原理，注意加上下面的JVM参数，
 * 参数目的就是为了：禁用指针压缩（指针压缩技术就是为了节省内存空间）
 * -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 */
public class V119_Demo3_10 {
    public static void test(Animal animal){
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Cat());
        test(new Dog());
        System.in.read();
    }

}

abstract class Animal{
    public abstract void eat();

    @Override
    public String toString() {
        return "我是"+this.getClass().getSimpleName();
    }
}
class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}

class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}