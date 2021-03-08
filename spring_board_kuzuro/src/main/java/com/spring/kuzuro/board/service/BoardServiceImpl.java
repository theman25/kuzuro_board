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

}
