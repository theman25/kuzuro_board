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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception {
		List<BoardVO> boardList;
		boardList = boardService.getBoardList();
		System.out.println("boardList : " + boardList.get(0).getContent());
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
}
