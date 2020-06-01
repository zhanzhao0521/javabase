package com.estrus.spi;


public class  Dog implements  IShout{

    @Override
    public void shout() {
        System.out.println("汪汪");
    }
}