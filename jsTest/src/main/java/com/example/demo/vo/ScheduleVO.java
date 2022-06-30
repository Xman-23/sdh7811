package com.example.demo.vo;



import java.util.Date;

import lombok.Data;

@Data
public class ScheduleVO {
	private int no;
	private String event_name;
	private Date event_date;
}
