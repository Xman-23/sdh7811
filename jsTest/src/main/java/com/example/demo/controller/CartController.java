package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CartDAO;
import com.example.demo.vo.CartListVO;
import com.example.demo.vo.CartVO;

import lombok.Setter;

@RestController
@Setter
public class CartController {
	
		@Autowired
		private CartDAO c_Dao; 
		
		@PostMapping("/insertCart")
		public String insert(@RequestBody List<CartVO> list)
		{
			System.out.println(list);
			
			return "OK";
		}
		
		/*
		 * @RequestMapping(value = "/insertCart",method = RequestMethod.GET) public
		 * String insert(CartVO[] c) {
		 * 
		 * // System.out.println(c);
		 * 
		 * System.out.println(Arrays.toString(c)); CartVO d = new CartVO();
		 * d.setNo(c_Dao.no());
		 * 
		 * c_Dao.insert(c);
		 * 
		 * return "OK"; }
		 */
}
