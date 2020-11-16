package com.myweb.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.UserVO;

//1. Filter 인터페이스를 상속받고, doFilter메서드를 오버라이딩 합니다
//2. 필터를 등록하는 방법 --- @WebFilter어노테이션 또는  web.xml에 필터설정

//@WebFilter("/*") - 모든요청
//@WebFilter("*.board") - board로 끝나는 모든요청
//@WebFilter("/board/write.board") - 특정요청
@WebFilter({"/board/write.board", "/board/regist.board"}) //글쓰기, 글 등록시 두 요청에서만 필터실행
public class BoardFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//ServletRequest은 HttpServletRequest의 부모타입 입니다.
		//형변환을 통해서 자식형태로 변환
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//세션은 얻어서 권한 확인
		HttpSession session = req.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) { //세션이 존재하지 않는다는 덧은 권한이 없음
			//res.sendRedirect("list.board"); --- 로그인하지 않으면 권한이 없으므로 글작성이 불가 -> list.board로 팅겨나감
			
			res.setContentType("text/html; charset=UTF-8"); //응답문서설정
			PrintWriter out = res.getWriter();
			out.println(" <script> ");
			out.println(" alert('로그인이 필요한 서비스 입니다'); ");
			out.println(" location.href='/MyWeb/user/login.user'; "); //로그인 화면
			out.println(" </script> ");
			
			return; //컨트롤러를 실행하지 않음.
		}
		
		chain.doFilter(request, response); //서블릿이나, 연결되어 있는 다른 필터를 실행
	}
	
	
	

}
