package com.spring.kuzuro.board.service;

import java.util.List;

import com.spring.kuzuro.board.domain.BoardVO;

public interface BoardService {

	// 게시물 목록
	public List<BoardVO> getBoardList() throws Exception;
	// 게시물 작성
	public void writeBoard(BoardVO vo) throws Exception;
}
