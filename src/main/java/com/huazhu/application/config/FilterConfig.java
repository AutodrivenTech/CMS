package com.huazhu.application.config;

import com.huazhu.application.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    /**
     * 配置过滤器
     * @return
     */
  //  @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(loginFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("loginFilter");
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
  //  @Bean(name = "loginFilter")
    public Filter loginFilter() {
        return new LoginFilter();
    }
}
