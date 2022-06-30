package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.CartManager;
import com.example.demo.vo.CartVO;

@Repository
public class CartDAO {
	public int insert(CartVO[] c)
	{
		return CartManager.insert(c);
	}
	
	public int no()
	{
		return CartManager.no();
	}
}
