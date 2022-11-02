package com.jago;

/**
 * 从字节码角度分析a++
 *
 * Code:
 *       stack=2, locals=3, args_size=1
 *          0: bipush        10
 *          2: istore_1
 *          3: iload_1
 *          4: iinc          1, 1
 *          7: iinc          1, 1
 *         10: iload_1
 *       LineNumberTable:
 *         line 8: 0
 *         line 9: 3
 *         line 10: 18
 *         line 11: 25
 *         line 12: 32
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      33     0  args   [Ljava/lang/String;
 *             3      30     1     a   I
 *            18      15     2     b   I
 */
public class V112_Demo3_2 {
    public static void main(String[] args) {
        int a = 10;//11
        int b = a++ + ++a + a--;//34
        System.out.println(a);
        System.out.println(b);
    }
}
