package com.hmily.concurrencyDemo.interceptor;

import com.hmily.concurrencyDemo.example.threadLocal.RequestHolder;
import com.hmily.concurrencyDemo.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor extends HandlerInterceptorAdapter {
    @Override   //进入controller前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        test();
        return true;
    }

    @Override   //不管有无异常一定会执行这个方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestHolder.remove();
        log.info("afterCompletion");
        return;
    }

    public void test(){
        throw new UserNotExistException("1003");
    }
}
