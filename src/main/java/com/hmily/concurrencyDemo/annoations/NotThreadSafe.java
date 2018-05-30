package com.hmily.concurrencyDemo.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 该注解是用来标记线程不安全的类或写法
 */
@Target(ElementType.TYPE)//指定该注解作用在哪
// @Retention(RetentionPolicy.RUNTIME)// 指定注解存在的范围
//      RUNTIME: 指定该注解会存在运行时的字节码文件，通过反射可拿到
@Retention(RetentionPolicy.SOURCE)  //指定该注解会在编译时忽略
public @interface NotThreadSafe {
    String value() default "";  //为方便拓展，给个默认值比较好
}
