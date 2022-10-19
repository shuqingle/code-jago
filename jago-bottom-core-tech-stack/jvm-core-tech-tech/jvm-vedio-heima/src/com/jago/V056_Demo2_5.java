package com.jago;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示弱引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class V056_Demo2_5 {
    private static final int _4MB = 4*1024*1024;

    public static void main(String[] args) {
        // list --:> weakreference --:> byte[] --:>
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list){
                System.out.println(w.get() + " ");
            }
            System.out.println();
        }
        System.out.println("循环结束");
    }
}
