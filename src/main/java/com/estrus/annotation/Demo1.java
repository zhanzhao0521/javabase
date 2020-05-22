package com.estrus.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class Demo1 {
    public static void main(String[] args) {
        Person person = new Student();
        person.eat();
        person.walk();
    }
    @Test
    public void testGetAnnotation(){
        Class<Student> studentClass = Student.class;
        Annotation[] classAnnotations = studentClass.getAnnotations();
        for (Annotation annotation :
                classAnnotations) {
            System.out.println(annotation);
        }
    }
}
//@MyAnnotation1(value = "hello")
//@MyAnnotation1()
//重复注解 jdk 8 之前不支持
@MyAnnotation1("hello")
@MyAnnotation1("hi1")
//jdk8之前使用数组重复注解
//@MyAnnotations({@MyAnnotation1(value = "hi"),@MyAnnotation1(value = "hello")})
class Person{
    private String name;
    private int age;

    public Person() {

    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}
class Student extends Person{
    public Student() {

    }

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
}

class Generic<@MyAnnotation1 T>{

    public void show() throws @MyAnnotation1 RuntimeException{
        ArrayList<@MyAnnotation1 String> objects = new ArrayList<>();
        int num = (@MyAnnotation1  int) 10L;
    }

}