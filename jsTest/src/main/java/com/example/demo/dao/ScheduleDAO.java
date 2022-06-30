package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ScheduleManager;
import com.example.demo.vo.ScheduleVO;

@Repository // 자동 스캔 을 위한 어노케이션 
public class ScheduleDAO {
	public int insert(ScheduleVO s)
	{
		return ScheduleManager.insert(s);
	}
	public List<ScheduleVO> s_findAll()
	{
		return ScheduleManager.s_findAll();
	}
}
