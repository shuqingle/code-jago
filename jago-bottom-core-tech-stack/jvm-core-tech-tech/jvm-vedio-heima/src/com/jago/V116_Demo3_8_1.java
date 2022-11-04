package com.jago;

/**
 * 从字节码角度判断a的值
 * cinit
 *
 *  Code:
 *       stack=1, locals=0, args_size=0
 *          0: bipush        10   //------------------>10放到操作数栈
 *          2: putstatic     #2   // Field a:I  //------------------>static变量赋值，赋值给常量池中名叫a的变量
 *          5: bipush        20
 *          7: putstatic     #2   // Field a:I  //------------------>static变量赋值，赋值给常量池中名叫a的变量
 *         10: bipush        30
 *         12: putstatic     #2   // Field a:I  //------------------>static变量赋值，赋值给常量池中名叫a的变量
 *         15: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 10: 5
 *         line 13: 10
 *         line 14: 15
 * }
 */
public class V116_Demo3_8_1 {

    static {
        a = 20;
    }
    static {
        a = 30;
    }
    static int a = 10;

    public static void main(String[] args) {

    }
}
