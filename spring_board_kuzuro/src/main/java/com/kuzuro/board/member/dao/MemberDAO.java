package com.kuzuro.board.member.dao;

import java.util.List;

import com.kuzuro.board.member.domain.MemberVO;

public interface MemberDAO {

	// 회원 등록
	public void insertMember(MemberVO vo) throws Exception;
	// 아이디 중복 체크
	public MemberVO checkId(String userId) throws Exception;
	// 회원 목록 조회
	public List<MemberVO> getMemberList(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	// 회원 총 명수
	public int getMemberCount(String searchType, String keyword) throws Exception;
	// 회원 조회
	public MemberVO getMember(String userId) throws Exception;
	// 회원 정보 수정
	public void updateMember(MemberVO vo) throws Exception;
	// 비밀 번호 변경
	public void updateMemberPw(MemberVO vo) throws Exception;
	// 회원 정보 삭제
	public void deleteMember(String userId) throws Exception;
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	// 로그 아웃
	public void logout() throws Exception;
}
