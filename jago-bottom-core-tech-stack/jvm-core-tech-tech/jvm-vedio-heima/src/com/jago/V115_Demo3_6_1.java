package com.jago;

/**
 * 从字节码角度分析代码运行结果
 *  Code:
 *       stack=2, locals=3, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: iconst_0
 *          3: istore_2
 *          4: iload_1
 *          5: bipush        10
 *          7: if_icmpge     21
 *         10: iload_2
 *         11: iinc          2, 1
 *         14: istore_2
 *         15: iinc          1, 1
 *         18: goto          4
 *         21: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *         24: iload_2
 *         25: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *         28: return
 *             0      29     0  args   [Ljava/lang/String;
 *             2      27     1     i   I
 *             4      25     2     x   I
 */
public class V115_Demo3_6_1 {
    public static void main(String[] args) {
        int i=0;
        int x=0;
        while (i<10){
            x=x++;
            i++;
        }
        System.out.println(x);//结果是0
    }
}
