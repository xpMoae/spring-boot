package com.basic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.bean.User;
import com.basic.dao.UserMapper;
import com.basic.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public User findUserById(String userId) {
		return mapper.getUserById(userId);
	}

	@Override
	public User findByUsername(User user) {
		return mapper.getUserByName(user);
	}

}
