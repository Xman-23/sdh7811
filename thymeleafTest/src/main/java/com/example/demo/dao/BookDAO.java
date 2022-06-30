package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BookManager;
import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {
	
	public List<BookVO> b_List()
	{
		return BookManager.b_List();
	}
	
	public BookVO findbyno(int bookid)
	{
		return BookManager.findbyno(bookid);
	}
	
	public int update(BookVO b)
	{
		return BookManager.update(b);
	}
	
	public int delete(int bookid)
	{
		return BookManager.delete(bookid);
	}
	
	public int insert(BookVO b)
	{
		return BookManager.insert(b);
	}
}
