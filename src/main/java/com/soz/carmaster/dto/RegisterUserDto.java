package com.soz.carmaster.dto;

import com.soz.carmaster.validation.PasswordConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterUserDto {

    @NotBlank(message = "Enter your name")
    private String userName;

    @NotBlank(message = "Enter your email")
    private String email;

    @PasswordConstraint
    @NotBlank(message = "Enter your password")
    private String password;

    @PasswordConstraint
    @NotBlank(message = "Confirm your password")
    private String confirmPassword;
}