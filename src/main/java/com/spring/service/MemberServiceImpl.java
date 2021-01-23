package com.spring.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.signup(vo);
	}

	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.signin(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	
	
}
