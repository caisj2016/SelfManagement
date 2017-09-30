package com.example.auth;

import org.springframework.security.core.authority.AuthorityUtils;

import com.example.dto.MemberDto;

import lombok.Data;

/**
 * @author Cai.sj
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private final MemberDto user;

	public LoginUserDetails(MemberDto user) {
		super(user.getLoginId(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}