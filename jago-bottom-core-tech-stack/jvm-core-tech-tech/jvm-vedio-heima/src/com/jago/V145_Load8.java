package com.jago;

/**
 * 演示final堆静态变量的影响
 * 使用javap -v -p xxx.class格式
 */
public class V145_Load8 {
    /**
     * static int a;
     *     descriptor: I
     *     flags: ACC_STATIC
     * 只是申明a，没有做赋值动作
     */
    static int a;
    /**
     *  static int b;
     *     descriptor: I
     *     flags: ACC_STATIC
     *
     *
     * static {};
     *     descriptor: ()V
     *     flags: ACC_STATIC
     *     Code:
     *       stack=1, locals=0, args_size=0
     *          0: bipush        10
     *          2: putstatic     #2                  // Field b:I
     *          5: return
     *       LineNumberTable:
     *         line 16: 0
     * 总结：赋值动作发生在类的构造方法中，而类的构造方法是在初始化阶段执行完成的
     */
    static int b = 10;
    /**
     *  static final int c;
     *     descriptor: I
     *     flags: ACC_STATIC, ACC_FINAL
     *     ConstantValue: int 20
     *
     * 总结：final静态基本类型变量赋值动作不是发生在初始化阶段，而是在准备阶段就完成了
     */
    static final int c = 20;
    /**
     *   static final java.lang.String d;
     *     descriptor: Ljava/lang/String;
     *     flags: ACC_STATIC, ACC_FINAL
     *     ConstantValue: String 123
     * 总结：特例：final静态String类型变量赋值动作不是发生在初始化阶段，而是在准备阶段就完成了
     */
    static final String d = "123";
    /**
     *static final java.lang.Object e;
     *     descriptor: Ljava/lang/Object;
     *     flags: ACC_STATIC, ACC_FINAL
     *
     *
     *  static {};
     *     descriptor: ()V
     *     flags: ACC_STATIC
     *     Code:
     *       stack=2, locals=0, args_size=0
     *          0: bipush        10
     *          2: putstatic     #2                  // Field b:I
     *          5: new           #3                  // class java/lang/Object
     *
     * 总结：static final的引用类型变量赋值（new），赋值操作发生在构造方法执行后（初始化阶段），而非准备阶段
     */
    static final Object e = new Object();
}
