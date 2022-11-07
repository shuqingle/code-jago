package com.jago;

/**
 * 多个single-catch块
 *
 * Code:
 *       stack=1, locals=3, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: bipush        10
 *          4: istore_1
 *          5: goto          26
 *          8: astore_2
 *          9: bipush        30
 *         11: istore_1
 *         12: goto          26
 *         15: astore_2
 *         16: bipush        40
 *         18: istore_1
 *         19: goto          26
 *         22: astore_2
 *         23: bipush        50
 *         25: istore_1
 *         26: return
 *       Exception table:
 *          from    to  target type
 *              2     5     8   Class java/lang/ArithmeticException
 *              2     5    15   Class java/lang/NullPointerException
 *              2     5    22   Class java/lang/Exception
 *
 *
 *  LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             9       3     2     e   Ljava/lang/ArithmeticException;
 *            16       3     2     e   Ljava/lang/NullPointerException;
 *            23       3     2     e   Ljava/lang/Exception;
 *             0      27     0  args   [Ljava/lang/String;
 *             2      25     1     i   I
 */
public class V124_Demo3_11_2 {
    public static void main(String[] args) {
        int i = 0;
        try{
            i=10;
        }catch (ArithmeticException e){
            i = 30;
        }catch (NullPointerException e){
            i = 40;
        }catch (Exception e){
            i = 50;
        }
    }
}
