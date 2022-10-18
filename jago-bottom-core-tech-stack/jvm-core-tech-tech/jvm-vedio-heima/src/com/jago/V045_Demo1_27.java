package com.jago;

import sun.misc.Unsafe;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Unsafe分配和释放直接内存
 */
public class V045_Demo1_27 {
    static int _1Gb = 1024*1024*1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base,_1Gb,(byte)0);
        System.in.read();
        unsafe.freeMemory(base);
        System.in.read();
    }

    public static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
          Unsafe unsafe =   (Unsafe)f.get(null);
          return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
