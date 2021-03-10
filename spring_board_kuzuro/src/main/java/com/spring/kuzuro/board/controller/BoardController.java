package com.spring.kuzuro.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.kuzuro.board.domain.BoardVO;
import com.spring.kuzuro.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService boardService;
	
	// 게시물 목록 조회
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getBoardList(Model model) throws Exception {
		List<BoardVO> boardList = null;
		boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		//return "board/list";
	}
	
	// 게시물 작성 화면 이동
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void getBoardWrite() throws Exception{
		
	}
	
	// 게시물 작성
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws Exception {
		boardService.writeBoard(vo);
		return "redirect:/board/list";
	}

	// 게시물 조회
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void getBoard(@RequestParam("bno") int bno, Model model) throws Exception {
		// @RequestParam([문자열])을 이용하면, 주소에 있는 특정한 값을 가져올 수 있습니다.
		// 조회수 증가
		boardService.updateViewCnt(bno);
		// 게시물 조회
		BoardVO vo = boardService.getBoard(bno);
		model.addAttribute("board", vo);
	}
	
	// 게시물 수정 화면 이동
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = boardService.getBoard(bno);
		model.addAttribute("board", vo);
	}
	
	// 게시물 수정
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyBoard(BoardVO vo) throws Exception {
		// Query String Parameters : bno : 1
		// Form Data : title : 제목, writer : 작성자, content : 내용
		//System.out.println("bno : " + vo.getBno());
		boardService.modifyBoard(vo);
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 게시물 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteBoard(int bno) throws Exception {
		boardService.deleteBoard(bno);
		return "redirect:/board/list";
	}
	
}
