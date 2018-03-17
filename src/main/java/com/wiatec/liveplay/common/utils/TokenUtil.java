package com.wiatec.liveplay.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * token util
 */
public class TokenUtil {

    public static String create(String s1, String s2){
        try {
            long time = System.currentTimeMillis();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((s1 + s2 + time).getBytes());
            BigInteger bigInteger = new BigInteger(1,messageDigest.digest());
            return bigInteger.toString(16).substring(8,24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String create32(String s1, String s2){
        try {
            long time = System.currentTimeMillis();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((s1 + s2 + time).getBytes());
            BigInteger bigInteger = new BigInteger(1,messageDigest.digest());
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean tokenValidate(String token){
        String tokenAfterDecrypt = AESUtil.decrypt(token,AESUtil.KEY);
        return tokenAfterDecrypt.startsWith("5c:41:e7");
    }

    public static String createKey(int i){
        return TokenUtil.create(i+"", "www.wiatec.com");
    }
}
