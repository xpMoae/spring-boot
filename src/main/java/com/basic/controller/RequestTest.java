package com.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.dao.RedisDao;
import com.basic.service.SuccessionService;

@RestController
public class RequestTest {

	@Autowired
	private SuccessionService service;
	
	@Autowired
	private RedisDao redisDao;

	@PostMapping("getAll")
	public Object getAll() {
		return service.getAll();
	}

	@PostMapping("testTransactional")
	public void testTransactional() {
		service.testTransactional();
	}
	
	@PostMapping("redisTest")
	public void redisTest() {
		redisDao.set("mykey", "myvalue");
		System.out.println(redisDao.get("mykey"));
	}
}
