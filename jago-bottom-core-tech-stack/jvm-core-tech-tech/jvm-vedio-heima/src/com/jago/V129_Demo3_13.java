package com.jago;

/**
 * synchronized关键字
 *  Code:
 *       stack=2, locals=4, args_size=1
 *          0: new           #2                  // class java/lang/Object(new对象后会将lock对象引用放到操作数栈)
 *          3: dup                               //复制lock对象引用并再次压入操作数栈
 *          4: invokespecial #1                  // Method java/lang/Object."<init>":()V（lock对象调用构造方法并引用出栈）
 *          7: astore_1                          //将对象引用赋值给锁变量lock
 *          8: aload_1                           //加载lock锁对象引用到操作数栈
 *          9: dup                               //复制lock锁对象引用（一个lock给monitorenter加锁指令使用，另外一个给monitorexist解锁指令使用）
 *         10: astore_2                          //将复制出来新的lock引用存入slot2号槽位
 *         11: monitorenter                      //栈顶剩余的lock对象引用配合monitorenter指令，并消耗掉lock引用
 *         12: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         15: ldc           #4                  // String ok
 *         17: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *         20: aload_2                           //执行完加锁代码后，如果没有异常，则加载slot2的lock对象到栈顶，配合monitorexist指令完成解锁，并消耗掉lock对象
 *         21: monitorexit
 *         22: goto          30
 *         25: astore_3                          //如果期间出现异常，异常表提示跳转到25行，把异常对象e存入slot3,取出slot2的lock对象，配合monitorexist指令对同一个对象解锁
 *         26: aload_2
 *         27: monitorexit
 *         28: aload_3                           //加载异常对象，抛出
 *         29: athrow
 *         30: return
 *       Exception table:
 *          from    to  target type
 *             12    22    25   any
 *             25    28    25   any
 *
 * LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      31     0  args   [Ljava/lang/String;
 *             8      23     1  lock   Ljava/lang/Object;
 */
public class V129_Demo3_13 {
    public static void main(String[] args) {
        Object lock = new Object();
        synchronized (lock){
            System.out.println("ok");
        }
    }
}
