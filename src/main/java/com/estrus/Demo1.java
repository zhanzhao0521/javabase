package com.estrus;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        double a4 = 0;
        int a5 = 0;
        int i = 0;
        int temp = 1;
        int count = 0;
        while (i++ < n){
            int value = scanner.nextInt();
            if (value % 5 == 0 && value % 2 == 0) a1 += value;
            if (value % 5 == 1){
                a2 += temp * value;
                temp *= -1;
            }
            if (value % 5 == 2) a3++;
            if (value % 5 == 3) {
                a4 += value;
                count++;
            }
            if (value % 5 == 4 && value > a5) a5 = value;
        }
        if (a1 != 0) System.out.print(a1 + " ");
        else System.out.print("N ");
        if (a2 != 0) System.out.print(a2 + " ");
        else System.out.print("N ");
        if (a3 != 0) System.out.print(a3 + " ");
        else System.out.print("N ");
        if (a4 != 0) System.out.format("%.1f ",a4/count);
        else System.out.print("N ");
        if (a5 != 0) System.out.print(a5);
        else System.out.print("N");
        scanner.close();
    }
}
