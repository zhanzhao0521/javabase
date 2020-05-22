package com.estrus.enumdemo;
import java.lang.Enum;
/**
 * @author hanzhanzhao
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于 java.lang.Enum 类
 */
public class Demo2 {
    public static void main(String[] args) {
        Season2 summer = Season2.SUMMER;
        //toString()
        System.out.println(summer.toString());
        System.out.println("*****************");
        //values()
        Season2[] values = Season2.values();
        for (Season2 value:values) {
            System.out.println(value);
            value.show();
        }
        System.out.println("*****************");
        Thread.State[] values1 = Thread.State.values();
        for (Thread.State state :
                values1) {
            System.out.println(state);
        }
        System.out.println("*****************");
        //valuesOf(String objName):返回枚举类中对象名是objName的对象
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);
        System.out.println("*****************");
        winter.show();
        //父类 java.lang.Enum;
        //System.out.println(Season2.class.getSuperclass());
    }
}

interface Info{
    void show();
}

enum Season2 implements Info{

    //1、提供当前枚举类的对象，多个对象之间用","隔开，末尾对象用";"结束
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER ("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2、声明Season的属性 private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //2、私有化类的构造器，并给对象属性赋值
    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节！");
//    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}