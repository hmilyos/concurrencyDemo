package com.hmily.concurrencyDemo.example.threadLocal;

public class RequestHolder {
    public final static ThreadLocal<Long>   requestHolder = new ThreadLocal<>();

    public static void add(Long value) {
        requestHolder.set(value);
    }

    public static Long getValue(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
