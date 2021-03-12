package com.spring.kuzuro.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.kuzuro.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sqlSession;
	
	private static String namespace = "com.spring.kuzuro.mapper.reply";
	
	// 댓글 목록 조회
	@Override
	public List<ReplyVO> getReplyList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".list", bno);
	}
	// 댓글 조회
	@Override
	public ReplyVO getReply(int bno, int rno) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("bno", bno);
		data.put("rno", rno);
		return sqlSession.selectOne(namespace + ".view", data);
	}
	// 댓글 작성
	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".write", vo);
	}
	// 댓글 수정
	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modify", vo);
		
	}
	// 댓글 삭제
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", vo);
		
	}

}
