package com.myproject.utils;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class LoginSecurity implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		System.out.println("管理员在这里！");
		User user = new User("root", "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
		
		return user;
	}

}
