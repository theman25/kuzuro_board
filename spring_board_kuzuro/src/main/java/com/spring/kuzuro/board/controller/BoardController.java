package com.spring.kuzuro.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.kuzuro.board.domain.BoardVO;
import com.spring.kuzuro.board.domain.Page;
import com.spring.kuzuro.board.domain.ReplyVO;
import com.spring.kuzuro.board.service.BoardService;
import com.spring.kuzuro.board.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService boardService;
	
	@Inject
	private ReplyService replyService;
	
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
	public void getBoardWrite(HttpSession session, Model model) throws Exception{
		Object loginInfo = session.getAttribute("member");
		if(loginInfo == null) {
			model.addAttribute("msg", false);
		}
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
		
		// 댓글 조회
		List<ReplyVO> replyList = null;
		replyList = replyService.getReplyList(bno);
		model.addAttribute("replyList", replyList);
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
		return "redirect:/board/listPageSearch?num=1";
	}
	
	// 게시물 목록 조회 + 페이징 추가
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void getBoardListPage(Model model, @RequestParam("num") int num) throws Exception {
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(boardService.getCountBoard());
		
		List<BoardVO> boardList = null;
		boardList = boardService.getBoardListPage(page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("page", page);
		/*
		model.addAttribute("pageNum", page.getPageNum());
		// 시작번호/끝번호
		model.addAttribute("startPageNum", page.getStartPageNum());
		model.addAttribute("endPageNum", page.getEndPageNum());
		// 이전/다음
		model.addAttribute("prev", page.isPrev());
		model.addAttribute("next", page.isNext());
		*/
		// 현재페이지
		model.addAttribute("select", num);
		
		/*
		// 게시물 총 갯수
		int count = boardService.getCountBoard();
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;
		// 하단 페이징 번호([게시물 총 갯수 / 한 페이지에 출력 할 갯수] 의 올림)
		int pageNum = (int) Math.ceil((double)count/postNum);
		// 출력할 게시물
		int displayPost = (num - 1) * postNum;
		// 한번에 표시 할 페이징 번호의 갯수
		int pageNum_cnt = 10;
		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int) (Math.ceil((double)num/(double)pageNum_cnt) * pageNum_cnt);
		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		// 마지막 번호 재계산
		int endPageNum_tmp = (int) (Math.ceil((double)count/(double)pageNum_cnt));
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<BoardVO> boardList = null;
		boardList = boardService.getBoardListPage(displayPost, postNum);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageNum", pageNum);
		// 시작번호/끝번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		// 이전/다음
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		// 현재페이지
		model.addAttribute("select", num);
		*/
	}
	
	// 게시물 목록 조회 + 페이징 + 검색
	@RequestMapping(value="/listPageSearch", method=RequestMethod.GET)
	public void getBoardListPageSearch(Model model, @RequestParam("num") int num, 
			@RequestParam(value="searchType", required = false, defaultValue="title") String searchType, 
			@RequestParam(value="keyword", required = false, defaultValue="") String keyword) throws Exception {
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(boardService.getBoardCountSearch(searchType, keyword));
		
		// 검색타입과 검색어
		//page.setSearchTypeKeyword(searchType, keyword);
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<BoardVO> boardList = null;
		//boardList = boardService.getBoardListPage(page.getDisplayPost(), page.getPostNum());
		boardList = boardService.getBoardListPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		//System.out.println("boardList : " + boardList);
		// 검색조건 유지를 위해
		//model.addAttribute("searchType", searchType);
		//model.addAttribute("keyword", keyword);
		
	}
}
