package com.estrus.string;

import org.junit.Test;

import java.util.HashSet;

public class Demo1 {
    public static void main(String[] args) {

        String s = "a";
        change(s);
        System.out.println(s);

    }
    public static void change(String a){
        a = "hello";
    }

    @Test
    public void test0(){
        HashSet<Object> objects = new HashSet<>();
        for (Object object : objects) {

        }
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
    }
}
