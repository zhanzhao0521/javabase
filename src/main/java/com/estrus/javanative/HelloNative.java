package com.estrus.javanative;

public class HelloNative {
    static{
        System.loadLibrary("HelloNative");
    }
    public native void sayHello();

    public static void main(String[] args) {
        new HelloNative().sayHello();
    }
}
