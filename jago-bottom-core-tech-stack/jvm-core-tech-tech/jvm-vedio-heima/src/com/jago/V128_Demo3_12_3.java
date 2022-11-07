package com.jago;

/**
 * finally出现了
 * Code:
 *       stack=1, locals=3, args_size=0
 *          0: bipush        10
 *          2: istore_0
 *          3: iload_0
 *          4: istore_1
 *          5: bipush        20
 *          7: istore_0
 *          8: iload_1
 *          9: ireturn
 *         10: astore_2
 *         11: bipush        20
 *         13: istore_0
 *         14: aload_2
 *         15: athrow
 *       Exception table:
 *          from    to  target type
 *              3     5    10   any
 *  LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             3      13     0     i   I
 */
public class V128_Demo3_12_3 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test(){
        int i = 10;
        try {
            return i;
        }finally {
           i=20;
        }
    }
}
