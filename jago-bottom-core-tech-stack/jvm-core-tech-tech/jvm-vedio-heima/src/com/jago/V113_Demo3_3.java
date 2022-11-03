package com.jago;

/**
 * 比较判断字节码指令
 * stack=1, locals=2, args_size=1
 *          0: iconst_0
 *          1: istore_1
 *          2: iload_1
 *          3: ifne          12//ifne成立，会跳到12行
 *          6: bipush        10//ifne不成立
 *          8: istore_1
 *          9: goto          15//赋值10后跳转到15结束，12和14不用执行
 *         12: bipush        20
 *         14: istore_1
 *             0      16     0  args   [Ljava/lang/String;
 *             2      14     1     a
 */
public class V113_Demo3_3 {
    public static void main(String[] args) {
        int a = 0;
        if (a==0){
            a = 10;
        }else {
            a= 20;
        }
    }
}
