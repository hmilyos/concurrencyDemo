package com.hmily.concurrencyDemo.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 等待其他线程就绪后一起执行
 */
@Slf4j
public class CyclicBarrierExample1 {
    private static CyclicBarrier cyclicBarrier =  new CyclicBarrier(5);
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("{}", e);
                }
            });
        }
        exec.shutdown();
    }
    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        cyclicBarrier.await();//等待其他线程就绪后一起执行
        log.info("{} is continue", threadNum);
    }
}
