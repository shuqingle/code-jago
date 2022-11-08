package com.jago;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 泛型集合取值
 *
 * Code:
 *       stack=2, locals=3, args_size=1
 *          0: new           #2                  // class java/util/ArrayList
 *          3: dup
 *          4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
 *          7: astore_1
 *          8: aload_1
 *          9: bipush        10
 *         11: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
 *         14: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
 *         19: pop
 *         20: aload_1
 *         21: iconst_0
 *         22: invokeinterface #6,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
 *         27: checkcast     #7                  // class java/lang/Integer
 *         30: astore_2
 *         31: return
 *       LineNumberTable:
 *         line 11: 0
 *         line 12: 8
 *         line 13: 20
 *         line 14: 31
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      32     0  args   [Ljava/lang/String;
 *             8      24     1  list   Ljava/util/List;
 *            31       1     2     x   Ljava/lang/Integer;
 *       LocalVariableTypeTable:
 *         Start  Length  Slot  Name   Signature
 *             8      24     1  list   Ljava/util/List<Ljava/lang/Integer;>;
 */
public class V132_Candy3 {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Integer> list = new ArrayList<>();
        list.add(10);//实际调用的是list.add(Object e)
        Integer x = list.get(0);//实际调用的是Object obj = list.get(index)


        //获取test方法参数泛型信息
        Method test = V132_Candy3.class.getMethod("test", List.class, Map.class);
        Type[] types = test.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType)type;
                System.out.println("原始类型 - "+parameterizedType.getRawType());
                Type[] arguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < arguments.length; i++) {
                    System.out.printf("泛型参数[%d] - %s\n",i,arguments[i]);
                }
            }
        }
        //获取test方法返回值泛型信息
        Type tps = test.getGenericReturnType();
        ParameterizedType parameterizedType = (ParameterizedType)tps;
        System.out.println("原始类型2 - "+parameterizedType.getRawType());
        Type[] arguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < arguments.length; i++) {
            System.out.printf("泛型参数2[%d] - %s\n",i,arguments[i]);
        }
    }

    //获取泛型信息
    public Set<Integer> test(List<String> list, Map<Integer,Object> map){
        return new HashSet<Integer>();
    }
}
