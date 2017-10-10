package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.common.PageName;
import com.example.dto.MemberDto;
import com.example.repository.UserRepository;
import com.example.service.JoinService;
import com.example.vo.JoinForm;

/**
 * @author Cai.sj
 */

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	UserRepository userRepository;

	public String join(JoinForm form, BindingResult result) {
		MemberDto member = new MemberDto();
		if (userRepository.count(form.getLoginId()) == 0) {
			member.setLoginId(form.getLoginId());
			member.setEncodedPassword(new BCryptPasswordEncoder().encode(form.getPassword()).toString());
			member.setNickName(form.getNickName());
			userRepository.save(member);

			return PageName.LOGININDEX;
		} else {
			result.rejectValue("loginId", "error.loginId", "注册的ID已经存在.");
			return PageName.JOININDEX;
		}
	}

}
