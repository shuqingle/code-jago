package com.jago;

/**
 * init构造方法
 * Code:
 *       stack=2, locals=3, args_size=3
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: ldc           #2                  // String s1
 *          7: putfield      #3                  // Field a:Ljava/lang/String;
 *         10: aload_0
 *         11: bipush        20
 *         13: putfield      #4                  // Field b:I
 *         16: aload_0
 *         17: bipush        10
 *         19: putfield      #4                  // Field b:I
 *         22: aload_0
 *         23: ldc           #5                  // String s2
 *         25: putfield      #3                  // Field a:Ljava/lang/String;
 *         28: aload_0
 *         29: aload_1      //构造方法的参数a,赋值给变量a
 *         30: putfield      #3                  // Field a:Ljava/lang/String;
 *         33: aload_0
 *         34: iload_2      ////构造方法的参数b,赋值给变量b
 *         35: putfield      #4                  // Field b:I
 *         38: return
 *       LineNumberTable:
 *         line 48: 0
 *         line 36: 4
 *         line 38: 10
 *         line 41: 16
 *         line 44: 22
 *         line 49: 28
 *         line 50: 33
 *         line 51: 38
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      39     0  this   Lcom/jago/V117_Demo3_8_2;
 *             0      39     1     a   Ljava/lang/String;
 *             0      39     2     b   I
 */
public class V117_Demo3_8_2 {


    private String a = "s1";
    {
        b = 20;
    }

    private int b = 10;

    {
        a = "s2";
    }


    public V117_Demo3_8_2(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        V117_Demo3_8_2 d = new V117_Demo3_8_2("s3",30);
        System.out.println(d.a);//s3
        System.out.println(d.b);//30
    }
}
