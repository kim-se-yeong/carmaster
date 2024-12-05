package com.soz.carmaster.service;

import com.soz.carmaster.data.User;
import com.soz.carmaster.dto.RegisterUserDto;

public interface UserService {

    User create(RegisterUserDto registerUserDto);

    User findByEmail();
}