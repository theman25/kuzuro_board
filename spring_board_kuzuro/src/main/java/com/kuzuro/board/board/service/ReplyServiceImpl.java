package com.kuzuro.board.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kuzuro.board.board.dao.ReplyDAO;
import com.kuzuro.board.board.domain.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	ReplyDAO replyDao;
	
	// 댓글 목록 조회
	@Override
	public List<ReplyVO> getReplyList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.getReplyList(bno);
	}
	// 댓글 조회
	@Override
	public ReplyVO getReply(int bno, int rno) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.getReply(bno, rno);
	}
	// 댓글 작성
	@Override
	public void writeReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.writeReply(vo);
	}
	// 댓글 수정
	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.modifyReply(vo);
	}
	// 댓글 삭제
	@Override
	public void deleteReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		replyDao.deleteReply(vo);
	}

}
