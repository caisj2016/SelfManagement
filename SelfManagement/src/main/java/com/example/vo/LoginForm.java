package com.example.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Cai.sj
 */
@Data
public class LoginForm {

	@NotNull
	private String loginId;

	@NotNull
	private String password;

}
