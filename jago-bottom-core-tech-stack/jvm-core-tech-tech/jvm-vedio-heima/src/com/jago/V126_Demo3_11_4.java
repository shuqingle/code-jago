package com.jago;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * finally
 *
 *  Code:
 *       stack=1, locals=4, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: bipush        10
 *          4: istore_1
 *          5: bipush        30
 *          7: istore_1
 *          8: goto          27
 *         11: astore_2
 *         12: bipush        20
 *         14: istore_1
 *         15: bipush        30
 *         17: istore_1
 *         18: goto          27
 *         21: astore_3
 *         22: bipush        30
 *         24: istore_1
 *         25: aload_3
 *         26: athrow
 *         27: return
 *       Exception table:
 *          from    to  target type
 *              2     5    11   Class java/lang/Exception
 *              2     5    21   any
 *             11    15    21   any
 */
public class V126_Demo3_11_4 {
    public static void main(String[] args) {
       int i = 0;
       try {
           i = 10;
       }catch (Exception e){
           i = 20;
       }finally {
           i = 30;
       }
    }
}
