package com.soz.carmaster.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CarController {

    //스프링 시큐리티는 로그인 후 기본적으로 인덱스 페이지로 redirection 된다.
    @GetMapping("/")
    public String home() {
        log.info("called home");
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        log.info("called index");
        return "index";
    }
}