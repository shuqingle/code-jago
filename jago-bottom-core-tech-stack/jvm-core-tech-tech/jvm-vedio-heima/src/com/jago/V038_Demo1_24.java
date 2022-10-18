package com.jago;

import java.io.*;

/**
 * stringTable性能调优
 * -XX:StringTableSize=200000 -XX:PrintStringTable
 */
public class V038_Demo1_24 {
    public static void main(String[] args) {
        //读取48W个单词
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"),"utf-8"))){
            String line = null;
            long start = System.nanoTime();
            while (true){
                line = reader.readLine();
                if (line == null) break;
                line.intern();
            }
            System.out.println("cost:"+(System.nanoTime()-start)/1000000);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
