package com.basic.utils;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;

public class JwtTokenProvider {
    SecretKeySpec key;
 
    /**
     * @param key
     *            密钥(例如：12345678)
     */
    public JwtTokenProvider(String key) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS512.getJcaName());
        this.key = secretKeySpec;
    }
 
    /**
     * 生成token
     * 
     * @return
     */
    public String createToken(Claims claims) {
        String compactJws = Jwts.builder().setPayload(JSONObject.toJSONString(claims))
                .compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, key).compact();
        return compactJws;
    }
 
    /** token转换为 */
    public Claims parseToken(String token) {
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
}
