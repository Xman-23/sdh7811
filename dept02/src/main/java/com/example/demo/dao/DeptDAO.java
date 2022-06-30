package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptVO;

@Repository
public class DeptDAO {
	public List<DeptVO> listDept(){
		return DBManager.listDept();
	}
	public int insertDept(DeptVO d)
	{
		return DBManager.insertDept(d);
	}
	
	public int updateDept(DeptVO d)
	{
		return DBManager.updateDept(d);
	}
	
	public int deleteDept(int dno)
	{
		return DBManager.deleteDept(dno);
	}
	public DeptVO getDept(int dno)
	{
		return DBManager.getDept(dno);
	}
}
