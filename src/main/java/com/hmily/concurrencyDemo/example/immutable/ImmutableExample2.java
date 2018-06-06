package com.hmily.concurrencyDemo.example.immutable;

import com.google.common.collect.Maps;
import com.hmily.concurrencyDemo.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }
    //经过unmodifiableMap处理后的map是不可以被修改的，
    // 虽然在写代码里面时可以允许你进行修改操作，但是运行时就会抛出异常。
    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
