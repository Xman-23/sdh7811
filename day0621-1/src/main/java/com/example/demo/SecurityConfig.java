package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration//자동 스캔
@EnableWebSecurity //어노케이션 적용
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.mvcMatchers("/","/hello","/all/**","/join").permitAll() // 인증을 하지 않아도 아무나 사용가능
		.mvcMatchers("/admin/**").hasRole("admin") //롤을 시켜라
		.anyRequest().authenticated();//그외의 사이트는 로그인을 해야 사용이 가능하다
		
		http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/service1"); // 아무나 상관없이 사용 가능(permitAll)
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그 아웃으로 갈 수 있게 만들고
		.invalidateHttpSession(true) //세션 을 무효화 시킨후 
		.logoutSuccessUrl("/login"); // 로그 아웃 이 성공 했을 시에 login 페이지로 넘어간다
		
		http.httpBasic();
		
		//super.configure(http);
	}

}
