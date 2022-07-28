package com.springboot.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@Service
public class UserInfoService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo uInfo = userRepository.getByUsername(username);
		if(uInfo == null)
			throw new UsernameNotFoundException("Invalid Credentials");

		// User role into List<GrantedAuthority>
		// We cannot convert role user.role into GrantedAuth so we use
		// SimpleGrantedAuth which implements GrantedAuth
		List<GrantedAuthority> list = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(uInfo.getRole());
		list.add(sga);
		// Convert UserInfo (User From DB) to UserDetails??
		// Converting Class to Interface?
		// We cannot convert UserInfo into UserDetails so we use
		// User which implements UserDetails
		User user = new User(uInfo.getUsername(), uInfo.getPassword(), list);
		return user;
	}

	public UserInfoService() {
		// TODO Auto-generated constructor stub
	}
}
