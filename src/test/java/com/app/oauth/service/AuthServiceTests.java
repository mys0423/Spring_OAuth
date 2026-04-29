package com.app.oauth.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AuthServiceTests {

    @Autowired
    private AuthService authService;

    @Test
    public void sendMemberPhoneCodeTest() {
        authService.sendMemberPhoneVerificationCode("01028249278");
    }

    @Test
    public void verifyMemberPhoneCodeTest() {
        authService.verifyMemberPhoneVerificationCode("01028249278","");
    }

    @Test
    public void sendMemberEmailCodeTest() {
        authService.sendEmailVerificationCode("mmmys2001@gmail.com");
    }
}
