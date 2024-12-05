package com.soz.carmaster.service;

import com.soz.carmaster.data.User;
import com.soz.carmaster.dto.RegisterUserDto;
import com.soz.carmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(RegisterUserDto registerUserDto) {

        User user = User.builder()
                .name(registerUserDto.getUserName())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .email(registerUserDto.getEmail())
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User findByEmail() {
        return null;
    }
}