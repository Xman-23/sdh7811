package com.example.demo.utill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

import lombok.Setter;

@Component
@Setter
@EnableScheduling
public class SendEmail {

	@Autowired
	private EmpDAO e;
	
	@Autowired
	private MailSender javaMailSender;
	
	//@Scheduled(cron = 초 분 시간 일 월 요일 연도)
	//만약에 매월 21일 11시에 동작 하도록 설정
	@Scheduled(cron = "10 37 11 21 * ?")
	public void send() 
	{
		
		  List<EmpVO> list = e.findAll();
		  
		  for(EmpVO e :list) 
		  { 
			  	String ename = e.getEname(); 
			  	String email =e.getEmail(); 
	
			  	int total = e.getSalary() + e.getComm(); 
		  
			  	if(email != null && !email.equals("")) 
		  
			  		{ 
			  			SimpleMailMessage mailMessage = new SimpleMailMessage();
			  			mailMessage.setSubject("모든 사원 급여");
			  			mailMessage.setFrom("tldkwnstn7811@gmail.com");
			  			mailMessage.setText(ename + "님 의 월급은" + total + "입니다 [담당자 :서동혁]");
			  			mailMessage.setTo(email);

			  			try {
							javaMailSender.send(mailMessage);
						} catch (Exception e2) {
							System.out.println("예외 발생" + e2);
						}
			  			
			  		}	 
		  }
		
	}
}
