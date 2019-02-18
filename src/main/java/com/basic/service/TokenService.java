package com.basic.service;

import com.basic.bean.User;

public interface TokenService {

	String getToken(User user);
	
	String getTimeToken(User user);
}
