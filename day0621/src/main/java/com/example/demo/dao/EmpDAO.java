package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.EmpManager;
import com.example.demo.vo.EmpVO;

@Repository
public class EmpDAO {

	
	public List<EmpVO> findAll()
	{
		return EmpManager.findAll();
	}
}
