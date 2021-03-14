package com.spring.kuzuro.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.kuzuro.member.dao.MemberDAO;
import com.spring.kuzuro.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDao;

	// 회원 등록
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
	}
	// 회원 목록 조회
	@Override
	public List<MemberVO> getMemberList(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getMemberList(displayPost, postNum, searchType, keyword);
	}
	// 회원 총명수 
	@Override
	public int getMemberCount(String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getMemberCount(searchType, keyword);
	}
	// 회원 정보 조회
	@Override
	public MemberVO getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.getMember(userId);
	}
	// 회원 정보 수정
	@Override
	public void updateMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}
	// 비밀 번호 변경
	@Override
	public void updateMemberPw(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		memberDao.updateMemberPw(vo);
	}
	// 회원 정보 삭제
	@Override
	public void deleteMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		memberDao.deleteMember(userId);
	}
	// 로그인 처리
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.login(vo);
	}
	// 로그아웃 처리
	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
