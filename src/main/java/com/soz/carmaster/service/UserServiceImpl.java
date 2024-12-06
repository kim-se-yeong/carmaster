package com.soz.carmaster.service;

import com.soz.carmaster.data.User;
import com.soz.carmaster.data.UserMapper;
import com.soz.carmaster.dto.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(RegisterUserDto registerUserDto) {

        User user = User.builder()
                .name(registerUserDto.getUserName())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .email(registerUserDto.getEmail())
                .enabled(true)
                .build();

        int result = userMapper.save(user);
        if (result > 0) {
            return user;
        }
        return null;
    }

    @Override
    public User findByEmail() {
        return null;
    }
}