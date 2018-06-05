package com.hmily.concurrencyDemo.example.singleton;

import com.hmily.concurrencyDemo.annoations.ThreadSafe;

//在类装载的时候就构造好了
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2(){ }
    //私有的构造方法和单例对象是必不可少的
    private static SingletonExample2 instance = new SingletonExample2();
    //饿汉模式：如果在类构造方法里面没有过多的处理，这种写法是可以接受的；
    // 如果其构造方法里有很多操作就会造成类加载很慢，引起性能问题
    //如果这个类被加载了却没被调用，是一种资源的浪费
    //建议：当构造方法操作不多，而且这个类必定会被用到的时候可以用恶汉模式

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
