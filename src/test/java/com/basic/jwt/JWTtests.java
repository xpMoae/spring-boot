package com.basic.jwt;

import com.basic.bean.UserClaims;
import com.basic.utils.JwtTokenProvider;

import io.jsonwebtoken.Claims;

public class JWTtests {
	public static void main(String[] args) {
		// md5("7981798723412342134"); > 签名

		// 密钥 12345678
		JwtTokenProvider jwtTokenProvider = new JwtTokenProvider("12345678");
		UserClaims claims = new UserClaims();
		claims.setUserName("Tony");
		claims.setEmail("tony@qq.com");
		// token有效期

		String token = jwtTokenProvider.createToken(claims);
		System.out.println("生成的token：" + token);
		// 生成Token
		Claims userClaims = jwtTokenProvider.parseToken(token);
		System.out.println("解析Toekn：" + userClaims);
	}
}
