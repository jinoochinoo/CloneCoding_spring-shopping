package com.spring.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.spring.mappers.memberMapper";
	
	@Override
	public void signup(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(vo.toString());
		sql.insert(namespace + ".signup", vo);
	}

}
