package com.spring.kuzuro.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.kuzuro.board.domain.Page;
import com.spring.kuzuro.member.domain.MemberVO;
import com.spring.kuzuro.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Inject
	private MemberService memberServic;
	
	// 회원 가입 화면 이동
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void goMemberRegist() throws Exception {
		
	}
	// 회원 가입
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute MemberVO vo) throws Exception {
		memberServic.insertMember(vo);
		return "redirect:/member/list?num=1";
	}
	// 회원 목록 조회
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getMemberList(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "userId") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception {
		Page page = new Page();
		page.setNum(num);
		int count = memberServic.getMemberCount(searchType, keyword);
		page.setCount(count);
		// 검색타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<MemberVO> memberList = null;
		memberList = memberServic.getMemberList(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	// 회원 정보 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getMember(@RequestParam("userId") String userId, Model model) throws Exception {
		MemberVO vo = memberServic.getMember(userId);
		model.addAttribute("member", vo);
	}
	// 회원 정보 수정 화면 이동
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public void goMemberView(@RequestParam("userId") String userId, Model model) throws Exception {
		MemberVO vo = memberServic.getMember(userId);
		model.addAttribute("member", vo);
	}
	// 회원 정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMember(MemberVO vo) throws Exception {
		memberServic.updateMember(vo);
		return "redirect:/member/view?userId=" + vo.getUserId();
	}
	// 비밀 번호 변경
	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
	public String updateMemberPw(MemberVO vo) throws Exception {
		memberServic.updateMemberPw(vo);
		return "redirect:/member/view?userId=" + vo.getUserId();
	}
	// 회원 정보 삭제
	public String deleteMember(@RequestParam("userId") String userId) throws Exception {
		memberServic.deleteMember(userId);
		return "redirect:/member/list?num=1";
	}
	// 로그인 페이지 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void gologin() throws Exception {
		
	}
	// 로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVo = memberServic.login(vo);
		if(memberVo == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/login";
		} else {
			session.setAttribute("member", memberVo);
			return "redirect:/";
		}
	}
	// 로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}
