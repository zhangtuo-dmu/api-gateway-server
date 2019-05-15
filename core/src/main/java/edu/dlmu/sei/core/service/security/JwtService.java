package edu.dlmu.sei.core.service.security;

import com.alibaba.fastjson.JSONObject;
import edu.dlmu.sei.common.enums.ErrorCodeEnum;
import edu.dlmu.sei.common.exception.BusinessException;
import edu.dlmu.sei.common.utils.CommonUtils;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * Created by zhangtuo on 2019-05-14.
 */
@Service
public class JwtService {
    private static final String KEY_STR = "API_GATEWAY_7WNFPDrX";

    public static String createJWT(String subject) {
        return createJWT(subject, 604800L);
    }

    /**
     * @param subject {"appKey":"123", "appSecret":"123"}
     * @param expireTimes 过期时间 多少ms
     * @return
     * @throws Exception
     */
    public static String createJWT(String subject, Long expireTimes) {
        Long nowMs = System.currentTimeMillis();
        Date now = new Date(nowMs);
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setId(CommonUtils.getUUID())                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setIssuedAt(now)           //iat: jwt的签发时间
                .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setExpiration(new Date(nowMs + expireTimes))
                .signWith(SignatureAlgorithm.HS256, key());//设置签名使用的签名算法和签名使用的秘钥
        return builder.compact();
    }

    private static SecretKey key() {
        return new SecretKeySpec(KEY_STR.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        SecretKey key = key();  //签名秘钥，和生成的签名的秘钥一模一样
        Jws<Claims> jws = null;
        try {
            jws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
        } catch (SignatureException | MalformedJwtException | IllegalArgumentException | CompressionException e) {
            // ExpiredJwtException异常漏到函数外处理
            throw new BusinessException(ErrorCodeEnum.TOKEN_ERROR);
        } catch (ExpiredJwtException e) {
            throw new BusinessException(ErrorCodeEnum.TOKEN_EXPIRED);
        }
        return jws.getBody();
    }

    public static void main(String[] args) {
        JSONObject o = new JSONObject();
        o.put("userId","");
        o.put("appKey","75834450");
        o.put("appSecret", "sZkhyVxPikLbLdsXWkYU");
        String access_token = createJWT(o.toJSONString());
        System.out.println("access_token : " + access_token);

        Claims claims = parseJWT(access_token);
        System.out.println("expireTime : " + claims.getExpiration());
        System.out.println("subject : " + claims.getSubject());

        String expireToken = createJWT(o.toJSONString(), 300L);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            parseJWT(expireToken);
        } catch (ExpiredJwtException e) {
            System.out.println("JWT过期");
        }
    }

}
