package com.jago;
/**
 * 方法重写时的桥接方法
 */
public class V141_BridegeMethod {

}
class V141_A {
    public Number m(){
        return 1;
    }
}
class V141_B extends V141_A{
    @Override
    public Integer m() {
        return 2;
    }
}

//class V141_B extends V141_A{
//    public Integer m() {
//        return 2;
//    }
//    //此方法才是真正重写了父类的pubic Number m()方法
//    public synthetic bridge Number m(){
//        return m();
//    }
//}