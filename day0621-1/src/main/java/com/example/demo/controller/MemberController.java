package com.example.demo.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.Member100VO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
		@Autowired
		private MemberDAO memberDAO;
	
		
		@Autowired
		private PasswordEncoder passwordEncoder; // 암호를 암호화 하기 위해 PasswordEncoder 
		
		@RequestMapping(value = "/login",method = RequestMethod.GET)
		//Post 방식은 Security가 제공한다
		public void login() {
			
		}
		
		@GetMapping("/join")
		public void joinForm()
		{
			
		}
		
		@PostMapping("/join")
		public ModelAndView joinSubmit(Member100VO m)
		{
			
			m.setPwd(passwordEncoder.encode(m.getPwd()));
			m.setRole("user"); //회원가입 할 시 role 에 user를 셋팅해준다
			memberDAO.insert(m);
			
			ModelAndView modelAndView = new ModelAndView("redirect:/login");
			
			return modelAndView;
		}
		
		@RequestMapping("/service1")
		public void service1(HttpSession session) {
		//로그인 한 회원의 정보를 가지고 오기 위하여 
		//먼저 Security 의 인증 객체가 필요하비다.
		Authentication authentication = 
					SecurityContextHolder.getContext().getAuthentication();
				
		
		//이 인증객체를 통해서 인증된(로그인한) User객체를 받아 옵니다
		User user = (User)authentication.getPrincipal();
		
		//이 인증된 User를 통해서 아이디를 갖고 옵니다. (detail)
		String id = user.getUsername();
		
		
		//이 정보를 세션에 상태 유지합닌다.
		// 만약 id 뿐 아니라 로그인한 회원 의 다른 정보도 필요하다면
		//dao를 통해서 회원 정보를 가지고 와서 상태유지를 합니다.
		session.setAttribute("id", id);
		}
}
