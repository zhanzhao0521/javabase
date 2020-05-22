package com.estrus.annotation;

/**
 * 自定义注解
 *  Annotation的成员变量在Annotation定义中以无参数方法的形式来声明
 * 可以使用default关键字指定成员变量的初始值
 * 如果只有一个参数，参数名建议使用value
 * 没有成员定义的Annotation称为标记；包含成员变量的Annotation称为元数据Annotation
 * 如果注解有成员，在使用注解时，需要指明成员的值
 *
 * 元注解：对现有注解进行修饰的注解
 *   @Retention  指明所修饰的Annotation的生命周期 SOURCE CLASS(defult) RUNTIME 只有 RUNTIME才能在运行时通过反射获取
 *   @Target     用于指定被修饰的Annotation 能用于修饰哪些程序元素
 *   @Documented  表示所修饰的注解在被javadoc解析式，保留下来
 *   @Inherited   被它修饰的Annotation 将具有继承性
 * 通过反射获取注解信息
 * jdk1.8新特性：
 * 可重复注解
 *          1.在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *          2.MyAnnotation的Target和Retention和MyAnnotations相同
 * 类型注解
 *    ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
 *    ElementType.TYPE_USE     表示该注解能写在使用类型的任何语句中
 */

import java.lang.annotation.*;

/**
 * @author hanzhanzhao
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation1 {
    String value() default "hello";
}




