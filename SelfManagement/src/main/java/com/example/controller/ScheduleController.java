package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.auth.LoginUserDetails;
import com.example.common.PageName;

/**
 * @author Cai.sj
 */
@Controller
public class ScheduleController {
	@RequestMapping(value = { "/scheduleIndex" })
	String scheduleIndex(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
		model.addAttribute("pageName", PageName.SCHEDULEINDEX);
		return PageName.SCHEDULEINDEX;
	}
}
