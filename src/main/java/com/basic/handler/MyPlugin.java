package com.basic.handler;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MyPlugin implements Interceptor {

	private long time;

//方法拦截
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 通过StatementHandler获取执行的sql
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		long start = System.currentTimeMillis();
		Object proceed = invocation.proceed();
		long end = System.currentTimeMillis();
		if ((end - start) > time) {
			System.out.println("本次数据库操作是慢查询，耗时：" + (end - start) + " 毫秒，sql是:" + sql);
		}
		return proceed;
	}

//获取到拦截的对象，底层也是通过代理实现的，实际上是拿到一个目标代理对象
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

//获取设置的阈值等参数
	@Override
	public void setProperties(Properties properties) {
		this.time = Long.parseLong(properties.getProperty("time"));
	}
}
