package com.estrus.binary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Demo1 {
    /**
     *补码减法
     *
     * 3:   0000 0011
     * 5:   0000 0101
     * -5:  1111 1011
     * 3-5: 1111 1110   （-2的补码）
     * 取反: 0000 0001
     *取反+1:0000 0010
     */
    @Test
    public void test1(){
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(3-5));
    }

    @Test
    public void test2(){
        //<<表示左移移，不分正负数，低位补0；
        System.out.println(5555555 << 2);
        //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1
        System.out.println(8 >> 2);
        //>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
        System.out.println(8 >>> 2);
    }
    @Test
    public void test3(){
        ArrayList<Object> objects = new ArrayList<>();
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        a[5] = 5;
        a[6] = 6;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.print("\n");
        System.arraycopy(a, 2, a, 3,  5);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.print("\n");
        int[] b = Arrays.copyOf(a, 20);
        System.out.println(b.length);
    }
}
