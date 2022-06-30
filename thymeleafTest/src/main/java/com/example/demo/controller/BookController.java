package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;

import lombok.Setter;

@Controller
@Setter
public class BookController {

	@Autowired
	private BookDAO dao;
	
	@GetMapping("/findAll")
	public void findAll(Model model)
	{
		model.addAttribute("list", dao.b_List());
	}
	
	@GetMapping("/detailBook/{bookid}")
	public ModelAndView detailBook(@PathVariable int bookid,Model model)
	{
			ModelAndView  mav = new ModelAndView("detailBook");
			model.addAttribute("b", dao.findbyno(bookid));
			
			return mav;
	}
	
	@GetMapping("/updateBook/{bookid}")
	public ModelAndView update(@PathVariable int bookid)
	{
		ModelAndView modelAndView = new ModelAndView("updateBook");
		int re = -1;
		modelAndView.addObject("b", dao.findbyno(bookid));
		
//		re = dao.update(bookid);
		
		return modelAndView;
	}
	@PostMapping("/updateBook")
	public ModelAndView updateBookOK(BookVO b)
	{
		int re = -1;
		ModelAndView mav = new ModelAndView("redirect:/findAll");
		
		re = dao.update(b);
		
		if (re != 1) {
			mav.addObject("msg", "수정에 실패하였습니다");
			mav.setViewName("error");
		}
		
		return mav;
	}
	@GetMapping("/deleteBook/{bookid}")
	public ModelAndView delete(@PathVariable int bookid)
	{
		int re = -1;
		
		ModelAndView mav = new ModelAndView("redirect:/findAll");
		re = dao.delete(bookid);
		
		if(re != 1)
		{
			mav.addObject("msg", "삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
		
	}
	
	@GetMapping("/insertBook")
	public void insertForm()
	{
		
	}
	
	@PostMapping("/insertBook")
	public ModelAndView insert(BookVO b)
	{
		int re = -1;
		ModelAndView modelAndView = new ModelAndView("redirect:/findAll");
		
		re = dao.insert(b);
		
		if(re != 1)
		{
			modelAndView.addObject("msg", "등록에 실패하였습니다");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
}
