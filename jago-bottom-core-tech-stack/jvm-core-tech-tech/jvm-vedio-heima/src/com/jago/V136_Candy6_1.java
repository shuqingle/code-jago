package com.jago;

public class V136_Candy6_1 {
    public static void main(String[] args) {
        choose("h");
    }


        //编译前
//        switch (str){
//            case "hello":
//                System.out.println("h");
//                break;
//            case "world":
//                System.out.println("w");
//                break;
//            default:
//                System.out.println("noting");
//        }
        public static void choose(String str){
        //编译后
        byte x = -1;
        switch (str.hashCode()){
            case 99162322://hello的hashcode
                if (str.equals("hello")){
                    x =0;
                }
                break;
            case 113318802://world的hashcode
                if (str.equals("world")){
                    x = 1;
                }
                break;
            default:


        }

        switch (x){
            case 0:
                System.out.println("h");
            case 1:
                System.out.println("w");
            default:

        }
    }
}
