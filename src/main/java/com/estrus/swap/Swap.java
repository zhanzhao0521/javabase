package com.estrus.swap;



public class Swap {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        swap1(a,b);
        System.out.println(a+","+b);
        IntSwap intSwap = new IntSwap(1, 2);
        swap2(intSwap);
        System.out.println(intSwap.a+","+intSwap.b);
    }
    public static void swap1(int a, int b){
        int temp ;
        temp = a;
        a = b;
        b = temp;
    }
    public static void swap2(IntSwap s ){

        int temp ;
        temp = s.a;
        s.a = s.b;
        s.b = temp;


    }

}
class IntSwap{
    int a;
    int b;

    public IntSwap(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
