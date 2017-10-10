package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.PageName;

@Controller
public class LoginController {
	@RequestMapping(value = "/loginIndex")
	String loginIndex() {
		return PageName.LOGININDEX;
	}

	@RequestMapping(value = "/dashboard")
	String loginSucess() {
		// 登録済みユーザー情報取得
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return PageName.DASHBOARD;
	}
}
