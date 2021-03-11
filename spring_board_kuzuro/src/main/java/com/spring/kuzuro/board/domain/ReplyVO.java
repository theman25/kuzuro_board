package com.spring.kuzuro.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ReplyVO {
	/*
	CREATE TABLE tbl_reply (
		rno 	int 		not null auto_increment,
		bno 	int 		not null,
		writer 	varchar(30) not null,
		content text 		not null,
		regDate timestamp 	not null default now(),
		PRIMARY KEY(rno, bno),
		FOREIGN KEY(bno) 	REFERENCES tbl_board(bno)
	);
	*/
	private int rno;
	private int bno;
	private String writer;
	private String content;
	private Date regDate;
}
