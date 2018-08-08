package com.huazhu.application.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.Random;


@Slf4j
public class PasswordUtil {

    private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateSalt() {
        return generateString(6);
    }
    public static String generate(String origin, String salt) {
        return getMD5(origin+salt);
    }

    public static Boolean check(String origin, String salt, String encoded) {
        return generate(origin, salt).equals(encoded);
    }

    private static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    private static String getMD5(String inputText) {
        if (StringUtils.isEmpty(inputText)) {
            throw new IllegalArgumentException("请输入要加密的内容");
        }

        try {
            MessageDigest m = MessageDigest.getInstance("md5");
            byte s[] = m.digest(inputText.getBytes("UTF8"));
            return hex(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr
     * @return
     */
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
}
