package com.example.demo;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SpringConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
	
		registry.addInterceptor(new MemberIntercepter())
		.addPathPatterns("/member/**")
		.excludePathPatterns("/member/images/**");
		 //멤버에대한 어떤 요청이든 
	}

}
