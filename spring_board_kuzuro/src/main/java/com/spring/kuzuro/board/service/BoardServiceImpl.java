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
	public List<BoardVO> getBoardList() {
		
		return boardDao.getBoardList();
	}

}
