package com.example.demo.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //json으로 데이터 추출
public class DollarController {

	@GetMapping("/money")
	public String Dollar() {
		String r = "";
		
		try {
			Document doc = Jsoup.connect("https://wise.com/kr/currency-converter/aud-to-krw-rate").get();
			//#Layer110 > table > tbody > tr > td
			//아이디 > 자식 > 자식 > 자식 > td (님이 원하는것)
		
			Elements list =doc.select("#calculator > div.cc-calculator > div.text-xs-center.text-lg-left");
			
			System.out.println("MeteoReady?" + list);
			
			r += list.text();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생:"+e.getMessage());
		}
		
		
		return r;
	}
}
