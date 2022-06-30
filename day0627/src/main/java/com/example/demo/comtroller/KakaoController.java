package com.example.demo.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KakaoController {

	@GetMapping("/KaKaoLoginOK/{name}/{email}")
	//상태 유지를 위해 session 을 사용
	public String KaKaoForm(@PathVariable String name, @PathVariable String email,HttpSession session) {
		
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		
		return "loginOK";

		
	}
}
