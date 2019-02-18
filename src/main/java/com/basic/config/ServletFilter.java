package com.basic.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(filterName="ServletFilter",urlPatterns="/*")
public class ServletFilter implements Filter {
 
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        chain.doFilter(request, response);
    }
 
    @Override
    public void init(FilterConfig config) {
        System.out.println("过滤器初始化");
    }

}