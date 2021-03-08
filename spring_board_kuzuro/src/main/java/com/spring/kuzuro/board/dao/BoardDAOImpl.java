package com.spring.kuzuro.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.kuzuro.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace = "com.spring.kuzuro.mapper.board";
	
	// 게시물 목록
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".list");
	}
	// 게시물 작성
	@Override
	public void writeBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".write", vo);
	}

}
