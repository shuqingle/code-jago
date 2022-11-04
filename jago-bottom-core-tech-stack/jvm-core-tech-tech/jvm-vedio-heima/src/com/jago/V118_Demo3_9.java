package com.jago;

/**
 * 方法调用字节码分析
 *
 *  Code:
 *       stack=2, locals=2, args_size=1
 *          0: new           #2                  // class com/jago/V118_Demo3_9
 *          3: dup
 *          4: invokespecial #3                  // Method "<init>":()V
 *          7: astore_1
 *          8: aload_1
 *          9: invokespecial #4                  // Method test1:()V
 *         12: aload_1
 *         13: invokespecial #5                  // Method test2:()V
 *         16: aload_1
 *         17: invokevirtual #6                  // Method test3:()V
 *         20: aload_1
 *         21: pop
 *         22: invokestatic  #7                  // Method test4:()V
 *         25: invokestatic  #7                  // Method test4:()V
 *         28: return
 *       LineNumberTable:
 *         line 19: 0
 *         line 20: 8
 *         line 21: 12
 *         line 22: 16
 *         line 23: 20
 *         line 24: 25
 *         line 25: 28
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      29     0  args   [Ljava/lang/String;
 *             8      21     1 demo3_9   Lcom/jago/V118_Demo3_9;
 */
public class V118_Demo3_9 {
    //构造方法
    public V118_Demo3_9() {}
    //私有方法
    private void test1(){}
    //私有final方法
    private final void test2(){}
    //普通公共方法
    public void test3(){}
    //静态代码
    public static void test4(){}

    public static void main(String[] args) {
        V118_Demo3_9 demo3_9 = new V118_Demo3_9();
        demo3_9.test1();
        demo3_9.test2();
        demo3_9.test3();
        demo3_9.test4();
        V118_Demo3_9.test4();
    }

}
