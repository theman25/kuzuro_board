package com.spring.kuzuro.board.dao;

import java.util.List;

import com.spring.kuzuro.board.domain.BoardVO;

public interface BoardDAO {

	// 게시물 목록
	public List<BoardVO> getBoardList() throws Exception;
	// 게시물 작성
	public void writeBoard(BoardVO vo) throws Exception;
	// 게시물 조회
	public BoardVO getBoard(int bno) throws Exception;
}
