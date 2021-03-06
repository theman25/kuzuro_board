package com.spring.kuzuro.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	/*
	create table tbl_board(
		bno int not null auto_increment,
		title varchar(50) not null,
		content text not null,
		writer varchar(30) not null,
		regDate timestamp not null default now(),
		viewCnt int default 0,
		primary key(bno)
	);
	*/
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
}
