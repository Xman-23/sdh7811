package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.CustomerManager;
import com.example.demo.vo.CustomerVO;

@Repository
public class CustomerDAO {
	public List<CustomerVO> findAll(){
		return CustomerManager.findAll();
	}
	
	public CustomerVO findByCustid(int custid) {
		return CustomerManager.findByCustid(custid);
	}
	
	public int insert(CustomerVO c) {
		return CustomerManager.insert(c);
	}
	
	public int update(CustomerVO c) {
		return CustomerManager.update(c);
	}
	
	public int delete(int custid) {
		return CustomerManager.delete(custid);
	}
}
