package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;

import org.apache.ibatis.io.Resources;

public class DBManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapconfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("예외 발생:" + e.getMessage());
		}
	
	}
	public static int insertGoods(GoodsVO g)
	{
		int re=-1;
		SqlSession session = sqlSessionFactory.openSession();
		re = session.insert("goods.insert",g);
		session.commit();
		session.close();
		return re;
	}
	public static List<GoodsVO> findAll(HashMap map)
	{
		List<GoodsVO> g_list = null;
		SqlSession session = sqlSessionFactory.openSession();
		g_list = session.selectList("goods.findAll",map);
		session.close();
		return g_list;
		
	}
	public static GoodsVO findByNo(int no)
	{
		GoodsVO g_Vo = null;
		SqlSession session = sqlSessionFactory.openSession();
		g_Vo = session.selectOne("goods.findByNo",no);
		session.close();
		return g_Vo;
	}
	public static int update(GoodsVO g)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re=session.update("goods.update",g);
		session.commit();
		session.close();
		return re;
	}
	public static int delete(int no)
	{
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession();
		re=session.delete("goods.delete",no);
		session.commit();
		session.close();
		return re;
	}
	public static int count()
	{
		int re = 0;
		
		SqlSession session = sqlSessionFactory.openSession();
		re = session.selectOne("goods.count");
		session.close();
		return re;
	}

}
