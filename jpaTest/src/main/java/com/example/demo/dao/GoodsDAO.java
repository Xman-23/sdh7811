package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.GoodsVO;


@Repository		
//T:물리적인 테이블이름 ,ID: Primary key(자료형)
public interface GoodsDAO extends JpaRepository<GoodsVO, Integer> {
																		
}
