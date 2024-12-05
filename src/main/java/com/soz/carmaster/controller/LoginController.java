package com.soz.carmaster.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {

    //로그인 페이지로 요청들어오면, classpath:templates/login 페이지를 보여주도록 한다.
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    //계정 비활성화 되어있을 때
    @GetMapping("/login-disabled")
    public String loginDisabled(Model model) {
        log.info("loginDisabled");
        model.addAttribute("loginDisabled", true);
        return "login";
    }
}
