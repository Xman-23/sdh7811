package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.Member100VO;


@Repository
public class MemberDAO {

		public Member100VO findById(String id)
		{
			return MemberManager.findByID(id);
		}
		
		public int insert(Member100VO m)
		{
			return MemberManager.insert(m);
		}
}
