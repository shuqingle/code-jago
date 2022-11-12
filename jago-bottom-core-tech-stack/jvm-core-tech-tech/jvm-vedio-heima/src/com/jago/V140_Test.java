package com.jago;

/**
 * addSuppressed添加被压制异常
 */
public class V140_Test {
    public static void main(String[] args) {
        try(MyResource resource = new MyResource()){
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class MyResource implements AutoCloseable{
    //资源关闭方法
    @Override
    public void close() throws Exception {
        throw new Exception("close异常");
    }
}
