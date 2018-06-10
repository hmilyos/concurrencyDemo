package com.hmily.concurrencyDemo.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionExample {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(() -> {
            try {
                reentrantLock.lock();//加入到AQS队列
                log.info("wait signal"); //输出顺序： 1
                condition.await();//从AQS队列移除，锁的释放
                    //并且被放入condition队列中等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程2释放锁而被唤醒执行
            log.info("get signal"); // 输出顺序：4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();//由于线程1的释放而得到锁
            log.info("get lock"); //输出顺序： 2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal ~ "); //输出顺序 3
            reentrantLock.unlock();//释放锁
        }).start();
    }

}
