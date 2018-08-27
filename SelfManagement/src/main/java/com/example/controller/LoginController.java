package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.auth.LoginUserDetails;
import com.example.common.PageName;

@Controller
public class LoginController {
	@RequestMapping(value = "/loginIndex")
	String loginIndex() {
		return PageName.LOGININDEX;
	}

	@RequestMapping(value = "/dashboard")
	String loginSucess(@AuthenticationPrincipal LoginUserDetails userDetails,Model model) {
		model.addAttribute("pageName",PageName.DASHBOARD);
		// 登録済みユーザー情報取得
		model.addAttribute("user", userDetails.getUser());
		return PageName.DASHBOARD;
	}
}
