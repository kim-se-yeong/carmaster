package com.soz.carmaster.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    /*
     * 6자 이상
     * 영문자 (대소문자 구분 X)
     * 특수문자 포함
     */
    private static final String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        boolean matches = password.matches(regex);
        if (!matches) {
            constraintValidatorContext.disableDefaultConstraintViolation(); //기본 메시지를 비활성화한다.
            constraintValidatorContext.buildConstraintViolationWithTemplate("6자 이상의 숫자, 영문자, 특수 문자를 포함한 비밀번호를 입력해주세요.")
                    .addConstraintViolation();
        }
        return matches;
    }
}