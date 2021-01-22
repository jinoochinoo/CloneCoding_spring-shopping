package com.spring.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	// 비밀번호 암호화
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	//회원가입 get
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public void getString() throws Exception{
		logger.info("get signup");
	}
	
	//회원가입 post
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String postSignup(MemberVO vo) throws Exception{
		logger.info("post signup");
		
		System.out.println(vo.toString());
		
		// 패스워드 BCrypt 암호화 -> 다시 vo 등록
		String inputPass = vo.getUserPass();
		String pass = passEncoder.encode(inputPass);
		vo.setUserPass(pass);
		
		service.signup(vo);
		
		return "redirect:/";
	}
	
}
