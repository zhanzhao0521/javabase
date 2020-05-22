package com.estrus.annotation;

import java.lang.annotation.*;

/**
 * 重复注解
 * @author hanzhanzhao
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
   MyAnnotation1[] value();
}




