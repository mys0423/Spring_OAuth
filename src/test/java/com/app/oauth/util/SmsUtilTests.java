package com.app.oauth.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SmsUtilTests {

    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void smsTest(){
        smsUtil.sendOneMemberPhone("01028249278", "메세지 확인");
    }

    @Test
    public void smsTest2(){
        smsUtil.sendMemberEmail("codefuling@gmail.com", "MYS", "안녕하세요");
    }
}
