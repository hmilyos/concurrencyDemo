package com.hmily.concurrencyDemo.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduledThreadPoolExample {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }   //延迟三秒执行
        }, 3, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.warn("schedule run");
            }//延迟一秒，并每隔3秒执行一次的定时器
        }, 1, 3, TimeUnit.SECONDS);
//        executorService.shutdown();//因为有定时器运行着，所以不用关闭

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }//从现在开始，每5秒执行一次
        }, new Date(), 5 * 1000);
    }

}
