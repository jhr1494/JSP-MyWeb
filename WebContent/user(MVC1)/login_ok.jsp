<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*
	1.로그인 페이지에서 넘어오는 id, pw 를 받습니다.
	2.반환유형 UserVO login 메서드에 (id, pw)를 매개변수로 넘깁니다.
		id, pw 기반으로 로그인검증 해서 결과가 있다면, UserVO에 select결과를 저장합니다.
		없다면 null 을 반환합니다.
		
	3. login_ok에서는 UserVO null이 아니면(로그인 성공) userVO 를 세션에 저장후에
	mypage.jsp 로 다이렉트 
	
	4. null 이라면 실패를 의미하므로, script로 " 아이디 비밀번호를 확인하세요"를 출력 후에 
	mypage.jsp 로 다이렉트 
	*/
	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	UserDAO dao = UserDAO.getInstance();
	UserVO vo = dao.login(id, pw);
	
	if(vo == null){ //아이디 비밀번호가 틀린경우
	%>
	<script>
		alert("아이디 비밀번호를 확인하세요");
		location.href= "login.jsp";
		
	</script>
		<%
	}else{// 로그인 성공
		session.setAttribute("user", vo);//세션 정보 저장
		response.sendRedirect("mypage.jsp");
	}
	
	
	
%>