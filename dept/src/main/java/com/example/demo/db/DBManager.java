package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVO;

public class DBManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	public static List<DeptVO> listDept(){
		List<DeptVO> list = null;
		SqlSession session  = sqlSessionFactory.openSession();
		list = session.selectList("dept.findAll");
		session.close();
		return list;
	}
	
	
	public static DeptVO getDept(int dno) {
		DeptVO d = null;
		SqlSession session = sqlSessionFactory.openSession();
		d = session.selectOne("dept.findByNo", dno);
		session.close();
		return d;
	}
	
	
	public static int insertDept(DeptVO d) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("dept.insert", d);
		session.close();
		
		//고주희 --> 고민지   1000 이체
		// update account set balance = balance - 1000 where name = '고주희';
		// update account set balance = balance + 1000 where name = '고민지';
		// 위와 같이 하나의 일처리를 위한 
		// 논리적인 작업단위(sql)를 트랜젝션
		// 이상황에서는 두개의 sql이 모두 성공했을때에 commit해야 합니다.
		// 하나라도 실패하면 작업을 전부 취소해야 합니다. rollback
		return re;
	}
	
	
	public static int updateDept(DeptVO d) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("dept.update", d);
//		session.commit();
		session.close();
		return re;
	}
	
	
	public static int deleteDept(int dno) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.delete("dept.delete",dno);
		session.close();
		return re;
	}	
	
}









