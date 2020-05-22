package com.estrus.enumdemo;

public class Demo3 {
    public static void main(String[] args) {
        Thread.State blocked = Thread.State.BLOCKED;
        switch (Thread.State.NEW){
            case BLOCKED:
                System.out.println(false);
            case WAITING:
                System.out.println(false);
            case NEW:
                System.out.println(true);
        }
    }
}
