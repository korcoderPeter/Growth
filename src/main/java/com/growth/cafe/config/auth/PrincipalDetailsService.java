package com.growth.cafe.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.growth.cafe.domain.member.Member;
import com.growth.cafe.domain.member.MemberRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member memberEntity = memberRepository.findByUsername(username);

		if (memberEntity == null) {
			return null;
		} else {
			return new PrincipalDetails(memberEntity);
		}

	}

}
