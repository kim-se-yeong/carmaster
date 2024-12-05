package com.soz.carmaster.config;

import com.soz.carmaster.data.User;
import com.soz.carmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 스프링 시큐리티에서 기본적으로 인증할 때 사용하는 USER, AUTHORITIES 테이블 대신,
 * 애플리케이션에서 사용자 정보를 관리하는 테이블을 통해 인증을 진행할 수 있도록 하기 위해 이 클래스를 생성하였다.
 * UserDetailsService 인터페이스 구현을 통해 애플리케이션의 사용자 테이블에서 정보를 가져와 스프링 시큐리티의 UserDetails 로 매핑한다.
 */

@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);
        log.info("user {}", user);
        if (user == null) {
            throw new UsernameNotFoundException("No user : " + username);
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getName())
                .password(user.getPassword())
                .disabled(!user.isEnabled())
                .roles("USER")
                .build();
    }
}
