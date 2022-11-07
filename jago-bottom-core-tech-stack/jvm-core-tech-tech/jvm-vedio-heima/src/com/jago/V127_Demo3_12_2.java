package com.jago;

/**
 * finally出现了
 *
 *  Code:
 *       stack=1, locals=2, args_size=0
 *          0: bipush        10
 *          2: istore_0
 *          3: bipush        20
 *          5: ireturn
 *          6: astore_1
 *          7: bipush        20
 *          9: ireturn
 */
public class V127_Demo3_12_2 {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test(){
        try {
            return 10;
        }finally {
            return 20;
        }
    }
}
