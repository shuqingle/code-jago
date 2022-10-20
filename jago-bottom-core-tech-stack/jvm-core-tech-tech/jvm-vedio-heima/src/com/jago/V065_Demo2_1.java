package com.jago;

import java.util.ArrayList;
import java.util.List;

/**
 * SerialGC是垃圾回收器，他的幸存区不会动态调整
 *测试垃圾回收
 * vm: -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 *
 * 打印日志时，GC就是MinorGC,fullGC就是fullGC
 */

public class V065_Demo2_1 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;


    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);
    }
}
