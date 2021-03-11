package com.spring.kuzuro.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.kuzuro.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession sqlSession;
	
	private static String namespace = "com.spring.kuzuro.mapper.reply";
	
	// 댓글 조회
	@Override
	public List<ReplyVO> getReplyList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".replyList", bno);
	}
	// 댓글 작성
	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".replyWrite", vo);
	}
	// 댓글 수정
	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".replyModify", vo);
		
	}
	// 댓글 삭제
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".replyDelete", vo);
		
	}

}
