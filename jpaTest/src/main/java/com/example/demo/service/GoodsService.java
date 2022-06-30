package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@Service
@Setter
public class GoodsService {
		
	@Autowired
	private GoodsDAO dao;
	
	public List<GoodsVO> findAll()
	{
		return dao.findAll(); //Goods 목록을 출력
	}
	
	//새로운 레코드를 등로하거나 수정할때에 사용합니다 (save)
	//PK가 이미 있으면 수정해주고 
	//없으면 추가 해 줍니다.
	public void save(GoodsVO g)
	{
		dao.save(g);
		//save 주식별자인 도서번호가  있으면 update,  없으면 insert를 수행
	}
	
	public GoodsVO getOne(int no)
	{
		return dao.getById(no);
	}
}	
