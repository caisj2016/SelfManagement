package com.example.service;

import org.springframework.validation.BindingResult;

import com.example.vo.JoinForm;

/**
 * @author Cai.sj
 */
public interface JoinService {

	/**
	 * 新建用户
	 * @return
	 */
	public String join (JoinForm form, BindingResult result);

}
