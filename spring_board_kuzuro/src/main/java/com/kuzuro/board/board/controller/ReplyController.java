package com.kuzuro.board.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kuzuro.board.board.domain.ReplyVO;
import com.kuzuro.board.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	
	// 댓글 목록 조회

	// 댓글 조회
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ReplyVO getReply(int bno, int rno) throws Exception {
		ReplyVO replyVo = replyService.getReply(bno, rno);
		return replyVo;
	}
	// 댓글 작성
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String writeReply(ReplyVO vo) throws Exception {
		replyService.writeReply(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	// 댓글 수정
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String updateReply(ReplyVO vo) throws Exception {
		replyService.modifyReply(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	// 댓글 삭제
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteReply(ReplyVO vo) throws Exception {
		replyService.deleteReply(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
}
