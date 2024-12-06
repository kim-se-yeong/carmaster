package com.soz.carmaster.data;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findByName(String name);

    int save(User user);
}