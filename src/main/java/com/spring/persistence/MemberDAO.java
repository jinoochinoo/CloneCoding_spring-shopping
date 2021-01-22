package com.spring.persistence;

import com.spring.domain.MemberVO;

public interface MemberDAO {

	public void signup(MemberVO vo) throws Exception;

}
