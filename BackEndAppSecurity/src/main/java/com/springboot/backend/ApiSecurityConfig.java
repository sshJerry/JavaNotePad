package com.springboot.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.backend.service.UserInfoService;

@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/customer").authenticated() //can do .permitAll() so anyone can access /customer
			.antMatchers("/products").authenticated()
			.antMatchers("/products/category/{cid}").hasAnyAuthority("ADMIN") //.hasAnyRole("ADMIN") if doing in mem auth
			.anyRequest().permitAll()
			.and().httpBasic()
			.and().csrf().disable();
		
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		.withUser("harry")
		.password(passwordEncoder().encode("potter"))
		.roles("ADMIN")
		.and()
		.withUser("ronald")
		.password(passwordEncoder().encode("ron"))
		.roles("EXEC");*/
		auth.authenticationProvider(getCustomerProvider());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		PasswordEncoder passEncode = new BCryptPasswordEncoder();
		return passEncode;
	}
	private DaoAuthenticationProvider getCustomerProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(userInfoService);
		return dao;
	}
}
