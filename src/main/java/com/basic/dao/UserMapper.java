package com.basic.dao;

import org.apache.ibatis.annotations.Param;

import com.basic.bean.User;

public interface UserMapper {

	User getUserById(String id);

	User getUserByName(@Param("user") User user);
}
