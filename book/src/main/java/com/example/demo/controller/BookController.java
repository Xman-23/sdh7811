package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping ("/name")
	@ResponseBody 
	public String hello() {		
		return "홍길동";
	}
	@RequestMapping ("/listBookJson")
	@ResponseBody
	public List<BookVO> listBook()
	{
		return dao.listBook(null);
	}
	
	
	@RequestMapping("/listBook")
	public void list(Model model,HttpSession session ,String keyword,String sortColumn,String searchColumn,String op) {
		System.out.println("정렬칼럼"+sortColumn);
		System.out.println("검색어" + keyword);
		System.out.println("컬럼" + searchColumn);
		System.out.println("부호" + op);
		
		/*
		if (keyword != null) {
				
			keyword = (String)session.getAttribute("keyword");
			searchColumn = (String)session.getAttribute("searchColumn");
		}*/
		//검색어 가 오지 않는데, 이전에 검색한 적이 있는지 물어본다.
		//검색어를 가지고 올떄에는 어떤 컬럼으로 검색했는지 검색컬럼도 같이 가지고 와야 합니다.
		if(keyword == null)
		{
			if (session.getAttribute("keyword") != null) {
				keyword = (String)session.getAttribute("keyword");
				searchColumn = (String)session.getAttribute("searchColumn");
			}
		}
		//정렬하는 컬럼은 오지 않는ㄷ
		
		HashMap map = new HashMap();
		map.put("sortColumn", sortColumn);
		map.put("keyword", keyword);
		map.put("searchColumn", searchColumn);
		map.put("op",op);
		
		model.addAttribute("list", dao.listBook(map));
		
		//검색을 했다면은 그 검색어와 검색칼럼을 세션에 저장합니다
		if(keyword != null)
		{
			session.setAttribute("keyword", keyword);
			session.setAttribute("searchColumn", searchColumn);
			//검색 칼럼이 가격이라면 연산자도 세션에 기록합니다.
			
			if (searchColumn.equals("price")) {

				op = (String)session.getAttribute("op");
			}
		}
		//정렬을 했다면 그 정렬한 칼럼을 세션에 저장합니다
		if(sortColumn != null)
		{
			session.setAttribute("searchColumn", searchColumn);
		}
		
	}
}








