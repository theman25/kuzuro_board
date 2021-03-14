package com.spring.kuzuro.member.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MemberVO {
	/*
	CREATE TABLE tbl_member (
		userId	VARCHAR(30)	NOT NULL,
		userPw	VARCHAR(30)	NOT NULL,
		userNm	VARCHAR(30)	NOT NULL,
		regDate 	timestamp 	NOT NULL DEFAULT NOW(),
		PRIMARY KEY(userId)
	);	
	*/
	private String userId;
	private String userPw;
	private String userNm;
	private Date regDate;
}
