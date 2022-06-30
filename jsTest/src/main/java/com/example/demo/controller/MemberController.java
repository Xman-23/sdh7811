package com.example.demo.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@RestController
@Setter
public class MemberController {
	@Autowired
	private MailSender javaMailSender;
	
	
	public MimeMessageHelper sendMail2(MimeMessage mimeMessage) throws MessagingException  {
		
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"UTF-8");
		message.setFrom("tldk1654@gmail.com");
		message.setTo("sdh7811@naver.com");
		message.setSubject("Meteo Ready?");
		message.setText("Ready get Set go <Img src='../goods/ball1.jpg'>",true);
		message.addInline("ball1", new ClassPathResource("../goods/ball1.jpg"));
		message.addAttachment("ball1.jpg", new ClassPathResource("doc/myDocument.pdf"));
		
		
		return message;
	}
	
	
	@GetMapping("/sendMail")
	public String sendMail(String email) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		String no = "";
		Random r  = new Random();
		no += r.nextInt(10);
		no += r.nextInt(10);
		no += r.nextInt(10);
		no += r.nextInt(10);
		
		
		mailMessage.setSubject("회원가입 안내");
		mailMessage.setFrom("tldkwnstn7811@gmail.com");
		mailMessage.setText("받은 인증번호를 입력해주세요");
		mailMessage.setText(no);
		mailMessage.setTo("sdh7811@naver.com");
		
		
		
		try {
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생 : " + e.getMessage());
		}
	
		
		return no;
	}
	
	@RequestMapping("/sendNUM")
	public String sendNUM(String tel) // to : 받는 사람 번호
	{
		String from = "01025598279";
		String no = "";
		Random r  = new Random();
		no += r.nextInt(10);
		no += r.nextInt(10);
		no += r.nextInt(10);
		no += r.nextInt(10);
		
		BitSms.sendMsg(from, tel, no);
		
		return no;
		
	}
}
