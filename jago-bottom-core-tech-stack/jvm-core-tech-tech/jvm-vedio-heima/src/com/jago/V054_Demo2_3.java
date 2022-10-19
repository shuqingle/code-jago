package com.jago;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/**
 * 演示软引用
 * 设置vm: -Xmx20m 就堆内存溢出
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * [GC (Allocation Failure) --[PSYoungGen: 4696K->4696K(6144K)] 17184K->17224K(19968K), 0.0007712 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Ergonomics) [PSYoungGen: 4696K->4544K(6144K)] [ParOldGen: 12528K->12481K(13824K)] 17224K->17026K(19968K), [Metaspace: 3265K->3265K(1056768K)], 0.0034620 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [GC (Allocation Failure) --[PSYoungGen: 4544K->4544K(6144K)] 17026K->17042K(19968K), 0.0005766 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * [Full GC (Allocation Failure) [PSYoungGen: 4544K->0K(6144K)] [ParOldGen: 12497K->624K(8704K)] 17042K->624K(14848K), [Metaspace: 3265K->3265K(1056768K)], 0.0047392 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 */
public class V054_Demo2_3 {
    private static final int _4MB = 4*1024*1024;

    public static void main(String[] args) throws IOException {
        //强引用：设置vm: -Xmx20m 就堆内存溢出
//        List<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//
//        System.in.read();
        soft();
    }

    public static void soft(){
        //软引用：内存紧张就释放
        //list --> softreference--> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            //关联软引用队列和软引用对象：当软引用关联的byte数组回收时，软引用对象会被自动加入到引用队列中
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
//            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        System.out.println("循环结束："+list.size());
        //从队列中获取无用的软引用对象并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll = queue.poll();
        }
        for (SoftReference<byte[]> ref : list){
            System.out.println(ref.get());
            //打印结果是4个null和一个对象
            //如果清除这个4个无用的软引用null?需要配合引用队列
        }

    }
}
