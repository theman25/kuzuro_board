package com.spring.kuzuro.board.dao;

import java.util.HashMap;
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
	// 게시물 조회
	@Override
	public BoardVO getBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".view", bno);
	}
	// 조회수 증가
	@Override
	public void updateViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".viewCnt", bno);
	}
	// 게시물 수정
	public void modifyBoard(BoardVO vo) throws Exception {
		sqlSession.update(namespace + ".modify", vo);
	}
	// 게시물 삭제
	@Override
	public void deleteBoard(int bno) throws Exception {
		sqlSession.delete(namespace + ".delete", bno);
	}
	// 게시물 총 갯수
	@Override
	public int getCountBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".count");
	}
	// 게시물 목록 조회 + 페이징
	@Override
	public List<BoardVO> getBoardListPage(int displayPost, int postNum) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sqlSession.selectList(namespace + ".listPage", data);
	}
	// 게시물 목록 조회 + 페이징 + 검색
	@Override
	public List<BoardVO> getBoardListPageSearch(int displayPost, int postNum, String searchType, String keword)
			throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keword", keword);
		return sqlSession.selectList(namespace + ".listPageSearch", data);
	}
	// 게시물 총 갯수 + 검색
	@Override
	public int getBoardCountSearch(String searchType, String keword) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("searchType", searchType);
		data.put("keword", keword);
		return sqlSession.selectOne(namespace + ".countSearch", data);
	}

}
