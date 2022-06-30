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

import com.example.demo.controller.vo.BookVO;

@RestController
public class BookController {

	@GetMapping("/book")
	public List<BookVO> bookList() {
		List<BookVO> b = new ArrayList<BookVO>();

		try {
			Document doc = Jsoup.connect("https://www.hanbit.co.kr/store/books/new_book_list.html").get();

			Elements list = doc.getElementsByClass("book_tit"); //클래스의 속성값으 가져온다 

			System.out.println("MeteoReady?" + list);

			for (Element e : list) {

				Element a = e.getElementsByTag("a").get(0);
				String title = a.text();
				String url = a.attr("href");
				System.out.println(title+"==>"+url);
				b.add(new BookVO(title,url));
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생:" + e.getMessage());
		}

		return b;

	}
}
