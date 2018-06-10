package com.hmily.concurrencyDemo.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CachedThreadPoolExample {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task: {}", index);
                }
            });
        }
        executorService.shutdown();
    }
}
