package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 확장자 패턴으로 변경 *.xxx로 맵핑을 변경
@WebServlet("*.test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestController() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dispatchServlet(request, response);
	}
	
	protected void dispatchServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2. doGet, doPost를 dispatchServlet으로 몰아주기
		//3. 요청분기
		request.setCharacterEncoding("utf-8"); //한글처리
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		
		String commend = uri.substring(conPath.length()); //uri - 패스경로
		
		System.out.println(commend);
		
		if(commend.equals("/controller/login.test")) {
			//로그인처리
		}else if(commend.equals("/controller/logout.test")) {
			//로그아웃처리
		}else if(commend.equals("/controller/update.test")) {
			//수정처리
		}
	}

}
