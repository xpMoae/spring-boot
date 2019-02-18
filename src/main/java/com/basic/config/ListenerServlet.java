package com.basic.config;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Administrator servletContext对象监听
 */
//@WebListener
public class ListenerServlet implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContex销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContex初始化:" + sce.getServletContext().getServerInfo());
	}
}

/**
 * @author Administrator request对象监听
 */
//@WebListener
class RequestListenter implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		System.out.println("http请求销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("http请求创建");
	}
}

/**
 * @author Administrator session对象监听
 */
//@WebListener
class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("session对象销毁");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("ession对象创建");
	}
}

/**
 * @author Administrator servletContext属性监听
 */
//@WebListener
class ContextAttribute implements ServletContextAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext添加属性");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext修改属性");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("ServletContext删除属性");
	}
}

/**
 * @author Administrator session对象监听
 */
//@WebListener
class SessionAttribute implements HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("HttpSession添加属性");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("HttpSession修改属性");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("HttpSession删除属性");
	}
}

/**
 * @author Administrator request对象监听
 */
//@WebListener
class RequestAttribute implements ServletRequestAttributeListener {
	@Override
	public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
		System.out.println("ServletRequest添加属性");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent  servletRequestAttributeEvent) {
		System.out.println("ServletRequest修改属性");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent  servletRequestAttributeEvent) {
		System.out.println("ServletRequest删除属性");
	}
}