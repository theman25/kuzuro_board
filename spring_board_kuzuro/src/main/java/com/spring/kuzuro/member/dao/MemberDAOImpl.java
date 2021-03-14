package com.spring.kuzuro.member.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.kuzuro.member.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace = "com.spring.kuzuro.mapper.memberMapper";
	// 회원 등록
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".regist", vo);
	}
	// 아이디 중복 체크
	@Override
	public MemberVO checkId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".checkId", userId);
	}
	// 회원 목록 조회
	@Override
	public List<MemberVO> getMemberList(int displayPost, int postNum, 
			String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sqlSession.selectList(namespace + ".selectList", data);
	}
	// 회원 총 명수
	@Override
	public int getMemberCount(String searchType, String keyword) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sqlSession.selectOne(namespace + ".selectCount", data);
	}
	// 회원 조회
	@Override
	public MemberVO getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectOne", userId);
	}
	// 회원 정보 수정
	@Override
	public void updateMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".update", vo);
	}
	// 비밀 번호 변경
	@Override
	public void updateMemberPw(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updatePw", vo);
	}
	// 회원 삭제
	@Override
	public void deleteMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", userId);
	}
	// 로그인 처리
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".login", vo);
	}
	// 로그 아웃 처리
	@Override
	public void logout() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
