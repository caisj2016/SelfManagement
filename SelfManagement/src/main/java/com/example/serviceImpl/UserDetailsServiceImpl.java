package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.auth.LoginUserDetails;
import com.example.dto.MemberDto;
import com.example.repository.UserRepository;

/**
 * @author Cai.sj
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	/*
	 * (非 Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

		// 認証を行うユーザー情報を格納する
		MemberDto user = null;
		try {
			user = userRepository.findOne(loginId);
		} catch (Exception e) {
			// 取得時にExceptionが発生した場合
			throw new UsernameNotFoundException("It can not be acquired User");
		}

		// ユーザー情報を取得できなかった場合
		if (user == null) {
			throw new UsernameNotFoundException("User not found for login id: " + loginId);
		}

		// ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
		return new LoginUserDetails(user);
	}

}