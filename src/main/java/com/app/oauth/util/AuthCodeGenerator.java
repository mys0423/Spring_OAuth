package com.app.oauth.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AuthCodeGenerator {

    // 보안적으로 안전
    private static final SecureRandom random = new SecureRandom();

    public static String generateAuthCode() {
        int code = random.nextInt(999999) + 100000;
        return String.valueOf(code);
    }


}
