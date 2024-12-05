package com.soz.carmaster.controller;

import com.soz.carmaster.dto.RegisterUserDto;
import com.soz.carmaster.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new RegisterUserDto());
        return "add-user";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") RegisterUserDto dto,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userService.create(dto);
        return "redirect:register?success";
    }
}