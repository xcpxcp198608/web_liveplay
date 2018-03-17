package com.wiatec.liveplay.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wiatec.liveplay.common.result.XException;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author patrick
 * @date 05/03/2018
 * create time : 10:25 PM
 */

public class JWTUtil {

    private static final String SECRET = "#hhjkhkh&jh2432@ndsf*_erkhwek234&ewhkjwehr^hfh234$2l3j4" +
            "o32urMiOiJ3aJpc3MiOiJ3aWF0ZWMiLCJzdWIiOiJsZWdhY3kiLCJuYmYiOjE1MjAyNjE5NTgsImJzdWIiOi" +
            "JsZWdhY3kiLCJuYmYiOjE1MjAyNjQ0MjksImV4cCI6MTUyMDM1MD2l3j4o3";

    /**
     * encode jwt token
     * @return token
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static String encode() throws UnsupportedEncodingException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date newDate = calendar.getTime();
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer("wiatec")
                .withSubject("legacy")
                .withNotBefore(date)
                .withExpiresAt(newDate)
                .sign(algorithm);
    }

    /**
     * decode jwt token
     * @param token token
     * @return expiration date
     */
    public static Date decode(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt();
    }

    /**
     * validate jwt token expiration
     * @param token token
     * @return is out expires
     */
    public static boolean validate(String token){
        DecodedJWT jwt;
        try {
            jwt = JWT.decode(token);
        }catch (Exception e){
            throw new XException(401, "access token invalid, can not trust");
        }
        Date expiresAt = jwt.getExpiresAt();
        return expiresAt.after(new Date());
    }

    /**
     * main test method
     */
    public static void main (String [] args) throws UnsupportedEncodingException {
        String s = encode();
        System.out.println(s);
        boolean b = validate(s);
        System.out.println(b);
    }

}
