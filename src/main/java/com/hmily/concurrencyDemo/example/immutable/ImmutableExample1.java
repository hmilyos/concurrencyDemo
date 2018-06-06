package com.hmily.concurrencyDemo.example.immutable;

import com.google.common.collect.Maps;
import com.hmily.concurrencyDemo.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        a = 2;//已经用final修饰，所以不可以再次赋值
//        b = "3";//已经用final修饰，所以不可以再次赋值
//        map = Maps.newHashMap();
        map.put(1, 3);  //用final修饰，还是可以修改和增加里面的值
        map.put(7, 8);
        log.info("{}", map.get(1));
        log.info("{}", map.get(7));
    }

    private void test(final int a) {
//        a = 1;  //已经用final修饰，所以不可以再次赋值
    }
}
