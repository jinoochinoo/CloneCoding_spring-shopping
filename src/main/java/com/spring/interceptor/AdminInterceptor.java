package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.domain.MemberVO;

// HandlerInterceptor 통해 컨트롤러보다 먼저 실행 (servlet-context 코드 등록)
public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res, Object obj) throws Exception{
		
		// 연결된 세션 check
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		// 인증 실패 -> 컨트롤러 진행 X, 첫 화면으로 되돌리기
		if(member == null || member.getVerify() != 9) {
			res.sendRedirect("/");
			return false;
		}
		// 인증 성공 -> 컨트롤러 진행
		return true;
	}
}
