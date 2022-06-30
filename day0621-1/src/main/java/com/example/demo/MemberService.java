package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.Member100VO;


import lombok.Setter;


@Service //자동 스캔
@Setter
public class MemberService implements UserDetailsService {

	@Autowired//의존관계 자동설정
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username = id
		
		System.out.println("사용자 로딩 처리");
		System.out.println(username);
		Member100VO m =dao.findById(username);
		
		if(m == null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		UserDetails user = User.builder()
				.username(username)
				.password(m.getPwd())
				.roles(m.getRole()).build();
		
		return user;
	}

}
