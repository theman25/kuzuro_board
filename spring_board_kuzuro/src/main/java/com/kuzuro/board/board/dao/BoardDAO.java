package com.kuzuro.board.board.dao;

import java.util.List;

import com.kuzuro.board.board.domain.BoardVO;

public interface BoardDAO {

	// 게시물 목록
	public List<BoardVO> getBoardList() throws Exception;
	// 게시물 작성
	public void writeBoard(BoardVO vo) throws Exception;
	// 게시물 조회
	public BoardVO getBoard(int bno) throws Exception;
	// 조회수 증가
	public void updateViewCnt(int bno) throws Exception;
	// 게시물 수정
	public void modifyBoard(BoardVO vo) throws Exception;
	// 게시물 삭제
	public void deleteBoard(int bno) throws Exception;
	// 게시물 총 갯수
	public int getCountBoard() throws Exception;
	// 게시물 목록 조회 + 페이징
	public List<BoardVO> getBoardListPage(int displayPost, int postNum) throws Exception;
	// 게시물 목록 조회 + 페이징 + 검색
	public List<BoardVO> getBoardListPageSearch(int displayPost, int postNum, String searchType, String keword) throws Exception;
	// 게시물 총 갯수 + 검색
	public int getBoardCountSearch(String searchType, String keword) throws Exception;
}
