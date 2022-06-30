package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.vo.SeatVO;



@RestController // json 으로 데이터 추출
public class LibraryController {

	@GetMapping("/seat")	
	public List<SeatVO> seat() {
			List<SeatVO> seatList = new ArrayList<SeatVO>();

			try {
				Document doc = Jsoup.connect("http://mpllc-seat.sen.go.kr/seatinfo/Seat_Info/1_count.asp").get();
				//#Layer110 > table > tbody > tr > td
				//아이디 > 자식 > 자식 > 자식 > td (님이 원하는것)
				System.out.println(doc);
				Elements list =doc.select("#Layer110 > table > tbody > tr > td.wating_f");
				
				System.out.println("MeteoReady?" + list);
				
				seatList.add(new SeatVO(list.text()));
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("예외 발생:"+e.getMessage());
			}
			return seatList;
		}
}
