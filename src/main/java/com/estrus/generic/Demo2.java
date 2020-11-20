package com.estrus.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    //上界通配符 < ? extends E>
    //上届：用 extends 关键字声明，表示参数化的类型可能是所指定的类型，或者是此类型的子类。
    static int countLegs(List<? extends Animal> animals){
       int retVal = 0;
        for (Animal animal : animals) {
            retVal+=retVal;
        }
       return  retVal;
    }
    static int countLegs1(List<Animal> animals){
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += retVal;
        }
        return  retVal;
    }

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        countLegs(list);
        //报错
        //countLegs1(list);
        List<Integer> dest = new ArrayList<>();
        List<Float> src = new ArrayList<>();
        List<Integer> src1 = new ArrayList<>();
        test(dest,src1);
        test1(dest,src);
    }

    public static <T extends Number> void test(List<T> dest,List<T> src){

    }

    public static void test1(List<?> dest,List<?> src){

    }
}

class Animal{

}

class Dog extends Animal{

}

