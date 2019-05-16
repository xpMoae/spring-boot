package com.basic.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogCostFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
		filterChain.doFilter(servletRequest, servletResponse);
		System.out.println("响应耗时：" + (System.currentTimeMillis() - start));
	}

	@Override
	public void destroy() {

	}
}