package com.jago;

/**
 * 查看类文件结构
 * 执行：javac -parameters -d . V097_HelloWorld.java
 * -parameters : 保留方法的参数名称信息
 * linux下编译命令： od -t xC V097_HelloWorld.class
 * 用vscode的插件Hex Editor打开.class文件，可以看到字节码的16进制显示（看到魔数CAFEBABE）
 */
public class V097_HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
