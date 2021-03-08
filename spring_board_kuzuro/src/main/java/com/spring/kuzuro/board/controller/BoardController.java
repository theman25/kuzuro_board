package com.spring.kuzuro.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.kuzuro.board.domain.BoardVO;
import com.spring.kuzuro.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService boardService;
	
	// 게시물 목록
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
}
