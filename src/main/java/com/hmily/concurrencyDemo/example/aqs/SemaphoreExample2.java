package com.hmily.concurrencyDemo.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {
    private final static int threadCount = 20;
    public static void main(String[] args) {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);//限定最多同时执行三个
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);//获得多个许可
                    test(threadNum);//并发数是3，又一次获取3个许可，
     // 同一秒内没有别的许可释放出来，相当于同一时间内只能调用一个去执行，类似单线程了
                    semaphore.release(3);//释放多个许可，也可以一个个释放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
