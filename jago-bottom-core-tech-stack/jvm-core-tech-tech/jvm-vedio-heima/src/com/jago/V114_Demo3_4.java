package com.jago;

/**
 * while循环控制指令
 *
 * Code:
 *       stack=2, locals=2, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: iload_1
 *          3: bipush        10
 *          5: if_icmpge     14
 *          8: iinc          1, 1
 *         11: goto          2
 *         14: return
 *       LineNumberTable:
 *         line 8: 0
 *         line 9: 2
 *         line 10: 8
 *         line 12: 14
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      15     0  args   [Ljava/lang/String;
 *             2      13     1     a   I
 */
public class V114_Demo3_4 {
    public static void main(String[] args) {
        int a = 0;
        while (a<10){
            a++;
        }
    }
}
