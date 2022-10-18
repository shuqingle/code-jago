package com.jago;

/**
 * 演示StringTable垃圾回收
 * 参数：-Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 */
public class V037_Demo1_7 {
    public static void main(String[] args) {
        int i = 0;
        try{
            for (int j = 0; j < 100000; j++) {//100000个触发垃圾回收
                String.valueOf(j).intern();
                i++;
            }
        }catch (Throwable e){

        }finally {
            System.out.println(i);
        }
    }
}
