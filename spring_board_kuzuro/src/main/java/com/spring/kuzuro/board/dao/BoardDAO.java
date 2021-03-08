package com.spring.kuzuro.board.dao;

import java.util.List;

import com.spring.kuzuro.board.domain.BoardVO;

public interface BoardDAO {

	// 게시물 목록
	public List<BoardVO> getBoardList();
}
