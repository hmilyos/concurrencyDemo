package com.hmily.concurrencyDemo;

import com.hmily.concurrencyDemo.filter.UserInfoFilter;
import com.hmily.concurrencyDemo.interceptor.UserInfoInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ConcurrencyDemoApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyDemoApplication.class, args);
	}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor())
                .addPathPatterns("/**");    //拦截所有请求
    }

    @Bean
    public FilterRegistrationBean userInfoFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new UserInfoFilter());   //刚才的filter
        registrationBean.addUrlPatterns("/threadLocal/*");  //要过滤的请求
        return registrationBean;
    }
}
