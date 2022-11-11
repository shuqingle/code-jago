package com.jago;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 语法糖-try-with-resource
 */
public class V139_Candy9 {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("123.txt");
            Throwable t = null;
            try {
                System.out.println(in);
            }catch (Throwable e1){
                //t是我们代码出现的异常
                t = e1;
                throw e1;
            }finally {
                //判断了资源不为空
                if (in != null){
                    //如果我们代码有异常
                    if (t != null){
                        try {
                            in.close();
                        }catch (Throwable e2){
                            //压制异常，如果close出现异常，作为被压制异常添加
                            t.addSuppressed(e2);
                        }
                    }else {
                        //如果我们代码没有异常,close出现的异常就是最后catch块中的e
                        in.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try(InputStream in = new FileInputStream("123.txt")){
//            System.out.println(in);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
