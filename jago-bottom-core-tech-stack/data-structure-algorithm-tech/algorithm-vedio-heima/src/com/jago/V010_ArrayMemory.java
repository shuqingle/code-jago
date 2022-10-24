package com.jago;

public class V010_ArrayMemory {
    //空间复杂度O(1)
    public static int[] reverse1(int[] arr){
        int n = arr.length;//4字节
        int temp ;//4字节
        //不用管传入的数组多大，我们需要8个字节来完成程序，所以空间复杂度O(8)，即O(1)
        for (int start = 0,end = n-1; start <=end; start++,end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }


    //空间复杂度O(n)
    public static int[] reverse2(int[] arr){
        int n = arr.length;//4字节
        int[] temp = new int[n]; ;//内容n*4字节+对象头及长度24字节
        //不管传入数组多大，我们需要4n+24+4个字节来完成程序，所以空间复杂度为O(4n+28),即O(n)
        for (int i = n-1; i >=0 ; i--) {
            temp[n-1-i] = arr[i];
        }
        return temp;
    }
}
