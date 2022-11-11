package com.jago;

/**
 * switch枚举
 */
public class V137_Candy7 {
    /**
     * 定义一个合成类（仅jvm使用，对我们不可见）
     * 用来映射枚举的ordinal与数组元素的关系
     * 枚举的ordinal表示枚举对象的序号，从0开始
     * 即male的ordinal=0,female的ordinal=1
     */

    static class $Map{
        //数组大小即为枚举元素个数，里面存储case用来对比的数字
        static int [] map = new int[2];
        static {
            map[Sex.FEMALE.ordinal()] = 1;
            map[Sex.MALE.ordinal()]=2;
        }
    }

    public static void foo(Sex sex){
        int x = $Map.map[sex.ordinal()];
        switch (x){
            case 1:
                System.out.println("男");
                break;
            case 2:
                System.out.println("女");
                break;
        }
    }












    public static void main(String[] args) {
        foo(Sex.FEMALE);
    }

//    public static void foo(Sex sex){
//        switch (sex){
//            case MALE:
//                System.out.println("男");
//                break;
//            case FEMALE:
//                System.out.println("女");
//                break;
//        }
//    }
}

enum Sex{
    MALE,FEMALE
}
