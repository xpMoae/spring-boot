package com.basic.service;

import com.basic.bean.Succession;
import com.github.pagehelper.PageInfo;

public interface SuccessionService {
	
	/**
	 * @return 注解sql获取列表
	 */
	PageInfo<Succession> getAll();

	/**
	 * 测试事务
	 */
	void testTransactional();

}
