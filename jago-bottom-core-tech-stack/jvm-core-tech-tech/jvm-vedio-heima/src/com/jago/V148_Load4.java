package com.jago;

/**
 * 类加载练习
 * 字节码角度分析：abc三个常量是否会导致类E的初始化
 *
 *  public static final int a;
 *     descriptor: I
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
 *     ConstantValue: int 10
 *
 *   public static final java.lang.String b;
 *     descriptor: Ljava/lang/String;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
 *     ConstantValue: String hello
 *
 *   public static final java.lang.Integer c;
 *     descriptor: Ljava/lang/Integer;
 *     flags: ACC_PUBLIC, ACC_STATIC, ACC_FINAL
 *
 *  static {};
 *     descriptor: ()V
 *     flags: ACC_STATIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String E init
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: bipush        20
 *         10: invokestatic  #5                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *         13: putstatic     #6                  // Field c:Ljava/lang/Integer;
 *         16: return
 */
public class V148_Load4 {
    public static void main(String[] args) {
//        System.out.println(V148_E.a);//不会导致E初始化
//        System.out.println(V148_E.b);//不会导致E初始化
        System.out.println(V148_E.c);//会导致E初始化
    }
}

class V148_E{
    static {
        System.out.println("E init");
    }
    public static final int a = 10;
    public static final String b = "hello";
    public static final Integer c = 20;//自动调用装箱操作Integer.valueOf()
}
