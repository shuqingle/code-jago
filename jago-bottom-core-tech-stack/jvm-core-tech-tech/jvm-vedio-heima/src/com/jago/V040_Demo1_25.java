package com.jago;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * stringTable性能调优
 * -XX:StringTableSize=200000 -XX:PrintStringTable
 */
public class V040_Demo1_25 {
    public static void main(String[] args) throws IOException {
        List<String> address = new ArrayList<>();
        //敲回车
        System.in.read();
        //读取48W个单词
        for (int i = 0; i < 10; i++) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"),"utf-8"))){
                String line = null;
                long start = System.nanoTime();
                while (true){
                    line = reader.readLine();
                    if (line == null) break;
                   address.add(line.intern());//内存占用40M
//                   address.add(line);//内存占用300M
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
        System.in.read();
    }
}
