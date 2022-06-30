package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DeptDAO;
import com.example.demo.vo.DeptVO;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@Controller
public class DeptController {

		@Autowired
		private DeptDAO dao;

		public DeptController(DeptDAO dao) {
			super();
			this.dao = dao;
		}
		
		@RequestMapping("/list.do")
		public void list(Model model)
		{
			System.out.println("리스트 동작함!");
			model.addAttribute("list", dao.listDept());
		}
		
		@RequestMapping(value = "/insert.do",method = RequestMethod.GET)	
		public void insertFor()
		{			
		}
		
		
		@RequestMapping(value = "/insert.do",method = RequestMethod.POST)
		public ModelAndView insertSubmit(DeptVO d)
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/list.do");
			
			int re = dao.insertDept(d);
			
			if(re != 1)
			{
				modelAndView.addObject("msg", "부서 등록에 실패하였습니다");
				modelAndView.setViewName("error");
			}
			
			
			return modelAndView;
			
			
		}
		
		@RequestMapping("/delete.do")
		public ModelAndView delete(int dno) {
			ModelAndView modelAndView = new ModelAndView("redirect:/list.do");
		int re	= dao.deleteDept(dno);
		
		 if (re != 1) {
			modelAndView.addObject("msg", "부서 삭제에 실패하였습니다");
			modelAndView.setViewName("error");
		 }
		 return modelAndView;
		}
		
		@RequestMapping(value = "/update.do", method = RequestMethod.GET)
		public void updateForm(Model model, int dno)
		{
			model.addAttribute("d", dao.getDept(dno));
		}
		
		@RequestMapping(value = "/update.do", method = RequestMethod.POST)
		public ModelAndView updateSubmit(DeptVO d) {
			ModelAndView modelAndView = new ModelAndView("redirect:/list.do");
			int re = dao.updateDept(d);
			if(re != 1)
			{
				modelAndView.addObject("msg", "부서 수정에 실패하였습니다");
				modelAndView.setViewName("error");
			}
			
			return modelAndView;
		}
}
