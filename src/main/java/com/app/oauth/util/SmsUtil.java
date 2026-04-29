package com.app.oauth.util;

import jakarta.annotation.PostConstruct;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SmsUtil {
    @Value("${coolsms.api.key}")
    private String apiKey;

    @Value("${coolsms.api.secret}")
    private String apiSecret;

    @Value("${spring.mail.username}")
    private String emailUsername;

    @Value("${spring.mail.password}")
    private String emailPassword;

    private DefaultMessageService messageService;
    private final JavaMailSenderImpl mailSender;

    @PostConstruct
    private void init(){
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
    }

    public SingleMessageSentResponse sendOneMemberPhone(String to, String content){
        Message message = new Message();

        // "01012341234" <- 형태로 전송해야 함.
        String toPhoneNumber = to.replaceAll("-", "");

        message.setTo(toPhoneNumber);
        message.setFrom("01028249278");
        message.setText(content);

        SingleMessageSentResponse response = this
                .messageService
                .sendOne(new SingleMessageSendingRequest(message));
        return response;
    }

    // 이메일 전송
    public void sendMemberEmail(String to, String subject, String content){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setFrom("mmmys2001@gmail.com", "몽자");

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new RuntimeException("메일 전송 실패" + e.getMessage());
        }

    }

}
