package com.example.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Cai.sj
 */
@Data
public class JoinForm {

	@NotNull
	private String nickName;

	@NotNull
	private String loginId;

	@NotNull
	private String password;

}
