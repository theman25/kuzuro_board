package com.kuzuro.board.board.dao;

import java.util.List;

import com.kuzuro.board.board.domain.ReplyVO;

public interface ReplyDAO {

	// 댓글 목록 조회
	public List<ReplyVO> getReplyList(int bno) throws Exception;
	// 댓글 조회
	public ReplyVO getReply(int bno, int rno) throws Exception;
	// 댓글 작성
	public void writeReply(ReplyVO vo) throws Exception;
	// 댓글 수정
	public void modifyReply(ReplyVO vo) throws Exception;
	// 댓글 삭제
	public void deleteReply(ReplyVO vo) throws Exception;
}
