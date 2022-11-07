package com.jago;

/**
 * 异常处理 try-catch块
 *
 *  Code:
 *       stack=1, locals=3, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: bipush        10
 *          4: istore_1
 *          5: goto          12
 *          8: astore_2
 *          9: bipush        20
 *         11: istore_1
 *         12: return
 *       Exception table:
 *          from    to  target type
 *              2     5     8   Class java/lang/Exception
 *       LineNumberTable:
 *         line 8: 0
 *         line 10: 2
 *         line 13: 5
 *         line 11: 8
 *         line 12: 9
 *         line 14: 12
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             9       3     2     e   Ljava/lang/Exception;
 *             0      13     0  args   [Ljava/lang/String;
 *             2      11     1     i   I
 */
public class V123_Demo3_11_1 {
    public static void main(String[] args) {
        int i = 0;
        try{
            i=10;
        }catch (Exception e){
            i = 20;
        }
    }
}
