package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

@RestController
@Setter
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping("/send")
	public String send() {
		javaMailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom("tldkwnstn7811@gamil.com"); //보내는 사람 gmail 설정
			     message.setTo("rola70@nate.com"); // 받는 사람
			     message.setSubject("첨부파일과 html 형태의 이메일 보내기"); //보내는 이메일 제목
			     String body = "<h2></h2>";
			     body +="<hr>";
			     body +="my text <img src='cid:ball'>";
			     message.setText(body, true);
			     message.addInline("ball", new ClassPathResource("com/example/demo/img/ball1.jpg"));
			     message.addAttachment("news.txt", 
			    		 new ClassPathResource("com/example/demo/data/news.txt")); 
			     
			   }
			 });
		
		
//		mailSender(JavaMailSender 형 변수 이름).send(new MimeMessagePreparator() {
//			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
//			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//			     message.setFrom("me@mail.com"); // 보내는 사람 gmail 설정
//			     message.setTo("you@mail.com"); // 받는 사람 
//			     message.setSubject("my subject"); // 보내는 이메일 제목
//			     message.setText("my text <img src='cid:myLogo'>", true);
													//	이미지의 아이디를 넣어준다
//			     message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
								//이미지의 아이드를 설정  				//패키지 를 만들고 패키지 안의 이미지 경로를 넣어준다
//			     message.addAttachment("myDocument.pdf", new ClassPathResource("doc/myDocument.pdf"));
										//보낼 파일의 이름 	 					//패키지를 만들고 패키지 안의 파일 의 경로를 넣어준다.
//			   }
//			 });
			return "OK";
	}
	
}
