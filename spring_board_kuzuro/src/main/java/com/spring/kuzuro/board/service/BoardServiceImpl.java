package com.spring.kuzuro.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.kuzuro.board.dao.BoardDAO;
import com.spring.kuzuro.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDao;
	
	// 게시물 목록
	@Override
	public List<BoardVO> getBoardList() throws Exception{
		
		return boardDao.getBoardList();
	}
	// 게시물 작성
	@Override
	public void writeBoard(BoardVO vo) throws Exception{
		boardDao.writeBoard(vo);
	}
	// 게시물 조회
	@Override
	public BoardVO getBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoard(bno);
	}
	// 조회수 증가
	@Override
	public void updateViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDao.updateViewCnt(bno);
	}
	// 게시물 수정
	public void modifyBoard(BoardVO vo) throws Exception{
		boardDao.modifyBoard(vo);
	}
	// 게시물 삭제
	@Override
	public void deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(bno);
	}
	// 게시물 총 갯수
	@Override
	public int getCountBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getCountBoard();
	}
	// 게시물 목록 조회 + 페이징
	@Override
	public List<BoardVO> getBoardListPage(int displayPost, int postNum) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardListPage(displayPost, postNum);
	}
	// 게시물 목록 조회 + 페이징 + 검색
	@Override
	public List<BoardVO> getBoardListPageSearch(int displayPost, int postNum, String searchType, String keword)
			throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardListPageSearch(displayPost, postNum, searchType, keword);
	}
	// 게시물 총 갯수 + 검색
	@Override
	public int getBoardCountSearch(String searchType, String keword) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoardCountSearch(searchType, keword);
	}

}
