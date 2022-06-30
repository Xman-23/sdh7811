package com.example.demo.db;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;import javax.swing.border.Border;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;

public class DBManager {

	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
	public static List<BoardVO> list_Board(HashMap map)
	{
		List<BoardVO> b_list = null;
		SqlSession session = sqlSessionFactory.openSession();
		b_list = session.selectList("board.findAll",map);
		session.close();
		
		return b_list;
	}
	public static BoardVO findByNo(int no)
	{
		BoardVO b_vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		b_vo = session.selectOne("board.findByNo",no);
		session.close();
		return b_vo;
	}
	
	public static int getNextNo()
	{
		int no = 0;
		SqlSession session = sqlSessionFactory.openSession();
		no = session.selectOne("board.getNextNo");
		session.close();
		return no;
	}
	
	public static int insertBoard(BoardVO b)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("board.insert", b);
		session.close();
		return re;
	}
	public static int updateBoard(BoardVO b)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.update("board.update",b);
		
		session.commit();
		session.close();
		return re;
	}
	public static int deleteBoard(int no , String pwd)
	{
		int re = -1;
		System.out.print("no:"+no);
		System.out.print("pwd:"+pwd);
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		SqlSession session = sqlSessionFactory.openSession();
		re=session.delete("board.delete",map);
		session.commit();
		session.close();
		return re;
	}
	
	public static void updateStep(int b_ref, int b_step) {
		SqlSession session = sqlSessionFactory.openSession();
		HashMap map = new HashMap<>();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		
		session.update("board.updateStep",map);
		session.commit();
		session.close();
		
	}
	public static int getTotalRecord() {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		cnt = session.selectOne("board.totalRecord");
		session.close();
		return cnt;
	}
}
