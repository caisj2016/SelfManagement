package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.common.PageName;
import com.example.service.JoinService;
import com.example.vo.JoinForm;

@Controller
public class JoinController {

	@Autowired
	private JoinService joinService;

	@RequestMapping(value = "/joinIndex")
	public String joinIndex() {
		return PageName.JOININDEX;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@Validated JoinForm form, BindingResult result ) {
		if (result.hasErrors()) {
			return PageName.JOININDEX;
		}
		String url = joinService.join(form, result);
		return url;
	}

}
