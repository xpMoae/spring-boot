package com.basic.serviceImpl;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.basic.bean.User;
import com.basic.service.TokenService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	// HS256算法
	@Override
	public String getToken(User user) {
		String token = "";
		token = JWT.create()
				.withJWTId(user.getId())//.withAudience(user.getId())
				.withExpiresAt(new Date(System.currentTimeMillis() + 10000))
				.withClaim("test data", "data")
				//.withIssuer("系统签发")
				.sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}

	@Override
	public String getTimeToken(User user) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 用ApiKey密钥签署JWT
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");// apiKey.getSecret()
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// 设置JWT声明
		JwtBuilder builder = Jwts.builder().setId(user.getId()).setIssuedAt(now).setSubject(user.getUsername())
				.setIssuer("系统签发").signWith(signatureAlgorithm, signingKey);

		// 设定后添加过期时间
		long expMillis = nowMillis + 10000;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp);

		// 构建JWT并将其序列化为一个紧凑的url安全字符串
		return builder.compact();
	}

}
