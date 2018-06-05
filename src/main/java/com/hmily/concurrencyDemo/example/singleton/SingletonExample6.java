package com.hmily.concurrencyDemo.example.singleton;


import com.hmily.concurrencyDemo.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonExample6 {
    // 私有构造函数
    private SingletonExample6() { }
    // 单例对象
    private static SingletonExample6 instance = null;
    /** 这里要注意先后顺序，如果static代码快在instance前就会造成空指针
     * 这里的加载是有先后顺序的 **/
    static {
        instance = new SingletonExample6();
    }

    // 静态的工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
