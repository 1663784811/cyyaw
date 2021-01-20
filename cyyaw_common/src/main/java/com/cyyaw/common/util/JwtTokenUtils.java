package com.cyyaw.common.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

/**
 * iss: jwt签发者
 * sub: jwt所面向的用户
 * aud: 接收jwt的一方
 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
 * nbf: 定义在什么时间之前，该jwt都是不可用的.
 * iat: jwt的签发时间
 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
 * secret : secret私钥
 */
public class JwtTokenUtils {
    // iss: jwt签发者
    public static final String ISS = "cyyaw";
    // sub: jwt所面向的用户
    public static final String SUB = "sso_";

    // 过期时间
    public static final long EXP = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7;
    // secret
    public static final String secret = "@#vws##35SW324";


    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    private static final JWTVerifier verifier;

    static {
        verifier = JWT.require(algorithm).withIssuer(ISS).build();
    }


    /**
     * 生成Token
     */
    public static String createToken(String name, String id, String role) {
        String token = JWT.create()
                .withIssuer(ISS)
                .withSubject(SUB)
                .withExpiresAt(new Date(EXP))
                .withNotBefore(new Date())
                .withIssuedAt(new Date())
                .withJWTId(id)
                .withClaim("name", name)
                .withClaim("role", role)
                .sign(algorithm);
        return token;
    }

    /**
     * 获取名称
     *
     * @param token
     * @return
     */
    public static String getName(String token) {
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("name").asString();
    }

    /**
     * 获取id
     *
     * @param token
     * @return
     */
    public static String getId(String token) {
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("id").asString();
    }

    /**
     * 获取角色
     *
     * @param token
     * @return
     */
    public static String getRole(String token) {
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("role").asString();
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verifierToken(String token) {
        try {
            DecodedJWT jwt = verifier.verify(token);
            return jwt != null;
        } catch (Exception e) {
            return false;
        }
    }

}
