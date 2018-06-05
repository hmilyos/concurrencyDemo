package com.hmily.concurrencyDemo.example.singleton;

import com.hmily.concurrencyDemo.annoations.NotThreadSafe;

@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1(){ }
    //私有的构造方法和单例对象是必不可少的
    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        // 这种方式在单线程下没问题，
        // 多线程下如果多个线程同时判断为null，就无法保证单例了
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
