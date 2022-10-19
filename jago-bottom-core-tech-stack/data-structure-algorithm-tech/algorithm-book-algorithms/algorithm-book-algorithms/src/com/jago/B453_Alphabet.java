package com.jago;

/**
 * 字母表API
 */
public class B453_Alphabet {
    //根据s中的字符创建一张新的字母表
    public B453_Alphabet(String s) {

    }
    //获取字母表索引位置的字符
    public char toChar(int index){
        return 'a';
    }
    //获取c的索引，在0- R-1之间
    public int toIndex(char c){
        return 0;
    }
    //c在字母表中吗
    public boolean contains(char c){
        return true;
    }
    //字母表中的字符数-基数
    public int R(){
        return 0;
    }
    //表示一个索引需要的比特数
    public int lgR(){
        return 0;
    }

    //将s转换为R进制的整数
    int [] toIndices(String s){
        return new int[0];
    }
    //将R进制的整数转换为基于该字母表的字符串
    String toChars(int [] indices){
        return "";
    }
}
