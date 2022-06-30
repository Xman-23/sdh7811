package com.example.demo.vo;



import lombok.Data;


@Data
public class CartVO {
	private int no;
	private int g_no;
	private int qty;
	public CartVO(int no, int g_no, int qty) {
		super();
		this.no = no;
		this.g_no = g_no;
		this.qty = qty;
	}
	public CartVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
