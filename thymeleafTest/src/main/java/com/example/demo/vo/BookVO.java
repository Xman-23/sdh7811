package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 기본 생성자를 제공한다 
@AllArgsConstructor //매개변수 갖는 생성자 (매개변수를 갖는 생성자를 생성하게 되면은)
@NoArgsConstructor // 매개변수 를 갖지 않는 생성자 (매개변수를 갖지 않는 생성자를 생성해줘야한다)
public class BookVO {
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
}
