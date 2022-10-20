package com.jago;

/**
 * 低位优先的字符串排序
 *
 * 第一轮前
 * BRT	T
 * ASD	D
 * ABD	D
 * ERV	V
 * EWR	R
 *
 *第一轮后
 * ASD	D
 * ABD	D
 * EWR	R
 * BRT	T
 * ERV	V
 *
 * 第二轮前
 * ASD	S
 * ABD	B
 * EWR	W
 * BRT	R
 * ERV	R
 *
 *第二轮后
 * ABD	B
 * BRT	R
 * ERV	R
 * ASD	S
 * EWR	W
 *
 * 第三轮前
 * ABD	A
 * BRT	B
 * ERV	E
 * ASD	A
 * EWR	E
 *
 * 第三轮后
 * ABD	A
 * ASD	A
 * BRT	B
 * ERV	E
 * EWR	E
 */
public class B459_LSD {
    public static void sort(String [] a,int W){
        //每个字符就是一个组，每个组对应次数，count[R+1] += count[R]，保证了索引一定从0开始，而且保证可以用次数大小构造的数组
        //通过前W个字符将a[]排序
        int N = a.length;//N=5
        int R = 256;//R =256
        String [] aux = new String[N];//["","","","",""]
        for (int d = W-1; d >=0 ; d--) {//根据第d个字符用键索引计数法排序，本测试数据一共3轮
            int [] count = new int[R+1];//计算出现频率，每个字符对应的数字存在256长度数组对应数字索引中，不然怎么知道为什么B>A
            for (int i = 0; i < N; i++) {//N=5,循环5次
                char c = a[i].charAt(d);
                int num = count[c];
                count[a[i].charAt(d)+1]++;
            }
            for (int r = 0; r < R; r++) {//将频率转化为索引
                count[r+1]+=count[r];
            }
            //每个字符串都出现在次数数组中，标定好字符串在次数数组中的位置即可
            for (int i = 0; i < N; i++) {//将元素分类
                char c = a[i].charAt(d);
                int num = count[c];
                String str = aux[num];
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {//回写
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String [] arr = new String[]{"BRT","ASD","ABD","ERV","EWR"};
        sort(arr,3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
//        char k = 'k';
//        System.out.println("sky".charAt(1));
//        System.out.println((int) k);
    }
}
