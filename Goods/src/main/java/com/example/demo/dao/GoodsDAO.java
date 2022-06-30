package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVO;
@Repository
public class GoodsDAO {
	//삽입
	public int insertGoods(GoodsVO g)
	{
		return DBManager.insertGoods(g);
	}
	//리스트
	public List<GoodsVO> findAll(HashMap map)
	{
		return DBManager.findAll(map);
	}
	//상세 목록
	public GoodsVO findByNo(int no)
	{
		return DBManager.findByNo(no);
	}
	//수정
	public int update(GoodsVO g)
	{
		return DBManager.update(g);
	}
	//삭제
	public int delete(int no)
	{
		return DBManager.delete(no);
	}
	//페이지 수
	public int count()
	{
		return DBManager.count();
	}
}
