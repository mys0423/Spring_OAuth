package com.app.oauth.api;

import com.app.oauth.domain.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/private")
@Slf4j
public class MyPageApi {

    @PostMapping("/my-page-test")
    public void test(Authentication authentication) {
        log.info("test {}", (MemberDTO)authentication.getPrincipal());
    }
}
