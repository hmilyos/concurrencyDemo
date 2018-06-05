package com.hmily.concurrencyDemo.example.singleton;

import com.hmily.concurrencyDemo.annoations.NotRecommend;
import com.hmily.concurrencyDemo.annoations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3(){ }
    //私有的构造方法和单例对象是必不可少的
    private static SingletonExample3 instance = null;
    //这里利用synchronized保证这肯定是单例的，
    // 但是带来了性能上的开销，所以不推荐这种写法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
