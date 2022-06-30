/**
 * 
 */
package com.example.demo.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author SIST
 *
 */

@Data //setter,getter 생성
@Entity //법인
@Table (name = "goods") //테이블 이름을 지어줌
public class GoodsVO { // 테이블 이름이 없을시에 GoodsVO 테이블이름
	@Id//Primary Key 설정 = @Id
	private int no;
	
	private String name;
	private int price;
	private int qty;
	private String fname;
}
