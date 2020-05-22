package com.estrus.generic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义泛型结构：泛型类，泛型接口，泛型方法
 */
public class Demo1 {

    @Test
    public void test1(){
        Order<String> stringOrder = new Order<String>("名字",12,"类型");
        Order<String> stringSubOrder1 = new SubOrder1<>("名字", 12, "类型");
    }

}
/**
 *泛型类
 */
class Order<T>{
    String orderName;
    int orderId;
    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}

/**
 * 子类在继承带泛型的父类时，指明了泛型的类型。则在实例化子类对象是，不需要再指明泛型
 * 不再是泛型类
 */
class SubOrder extends Order<Integer>{

    public SubOrder(String orderName, int orderId, Integer orderT) {
        super(orderName, orderId, orderT);
    }
}

/**
 * 仍然是泛型类
 * @param <T>
 */
class SubOrder1<T> extends Order<T>{
    public SubOrder1(String orderName, int orderId, T orderT) {
        super(orderName, orderId, orderT);
    }
}
