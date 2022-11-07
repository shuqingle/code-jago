package com.jago;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * multi-catch的情况
 * Code:
 *       stack=3, locals=2, args_size=1
 *          0: ldc           #2                  // class com/jago/V125_Demo3_11_3
 *          2: ldc           #3                  // String test
 *          4: iconst_0
 *          5: anewarray     #4                  // class java/lang/Class
 *          8: invokevirtual #5                  // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
 *         11: astore_1
 *         12: aload_1
 *         13: aconst_null
 *         14: iconst_0
 *         15: anewarray     #6                  // class java/lang/Object
 *         18: invokevirtual #7                  // Method java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
 *         21: pop
 *         22: goto          30
 *         25: astore_1
 *         26: aload_1
 *         27: invokevirtual #11                 // Method java/lang/ReflectiveOperationException.printStackTrace:()V
 *         30: return
 *       Exception table:
 *          from    to  target type
 *              0    22    25   Class java/lang/NoSuchMethodException
 *              0    22    25   Class java/lang/IllegalAccessException
 *              0    22    25   Class java/lang/reflect/InvocationTargetException
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *            12      10     1  test   Ljava/lang/reflect/Method;
 *            26       4     1     e   Ljava/lang/ReflectiveOperationException;
 *             0      31     0  args   [Ljava/lang/String;
 */
public class V125_Demo3_11_3 {
    public static void main(String[] args) {
        try {
            Method test = V125_Demo3_11_3.class.getMethod("test");
            test.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
           e.printStackTrace();
        }
    }
}
