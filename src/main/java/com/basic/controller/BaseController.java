package com.basic.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.bean.User;
import com.basic.service.UserService;

@RestController
@ResponseBody
public class BaseController {

	@Autowired
	private UserService service;

	@PostMapping("getUserById")
	public String getUserById(@Param("id") Integer id) {

		User user = service.findUserById(id + "");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return user == null ? "异常用户" : user.getUsername();
	}

}
