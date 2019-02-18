package com.basic.service;

import com.basic.bean.User;

public interface UserService {

	public User findUserById(String userId);

	public User findByUsername(User user);

}
