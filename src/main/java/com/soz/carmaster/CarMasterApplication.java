package com.soz.carmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

@EnableJpaAuditing
@SpringBootApplication
public class CarMasterApplication {

	public static void main(String[] args) {

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		for (GrantedAuthority authority : authorities) {
//			System.out.println("Authority: " + authority.getAuthority());
//		}
		SpringApplication.run(CarMasterApplication.class, args);

	}
}