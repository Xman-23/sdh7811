package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {	
	@Autowired
	private DeptDAO dao;
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/list.do")
	public void list(Model model) {
		model.addAttribute("list", dao.listDept());
	}
	
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVO d) {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		int re = dao.insertDept(d);
		if(re != 1) {
			mav.addObject("msg", "부서 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(int dno) {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		int re = dao.deleteDept(dno);
		if(re != 1) {
			mav.addObject("msg", "부서 삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public void updateForm(Model model,  int dno) {
		model.addAttribute("d", dao.getDept(dno));
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(DeptVO d) {
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		int re = dao.updateDept(d);
		if(re != 1) {
			mav.addObject("msg", "부서 수정에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}






























