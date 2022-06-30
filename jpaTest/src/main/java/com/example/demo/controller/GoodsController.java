package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.GoodsService;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@Controller
@Setter
public class GoodsController {

	@Autowired // 의존관계 자동설정
	private GoodsService goodsService;

	@GetMapping("/listGoods")
	public void listGoods(Model model) {

		model.addAttribute("list", goodsService.findAll());
	}
	
//	@GetMapping("/insertGoods") //static
//	public void insert() {
//		
//		
//	}
	
	@PostMapping("/saveGoods")
	public ModelAndView insert(GoodsVO g) {
	ModelAndView modelAndView = new ModelAndView("redirect:/listGoods");	
	goodsService.save(g);
	return modelAndView;
	}
	
	@GetMapping("/updateGoods/{no}")
	public ModelAndView updateForm(@PathVariable int no, Model model)
	{
		model.addAttribute("g", goodsService.getOne(no)); // 해당 게시물의 정보를 가져옴
		ModelAndView mav = new ModelAndView("updateGoods");
		return mav;
	}
	
	
}
