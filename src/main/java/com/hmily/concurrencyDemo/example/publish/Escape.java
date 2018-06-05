package com.hmily.concurrencyDemo.example.publish;

import com.hmily.concurrencyDemo.annoations.NotRecommend;
import com.hmily.concurrencyDemo.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j  //对象溢出
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
