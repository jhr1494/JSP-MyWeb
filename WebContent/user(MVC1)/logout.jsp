<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 
	session.invalidate(); //세션 무효화 
	response.sendRedirect(request.getContextPath()); //getContextPath() = home화면으로
	

%>