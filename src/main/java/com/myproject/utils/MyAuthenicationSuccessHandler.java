package com.myproject.utils;

import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

public class MyAuthenicationSuccessHandler extends AuthenticationSuccessEvent{

	public MyAuthenicationSuccessHandler(Authentication authentication) {
		super(authentication);
		System.out.println("成功登陆逻辑");
	}

}
