<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../include/header.jsp" %>
    
   <%
   //마이페이지(로그인 만료)
   if(session.getAttribute("user")==null){
	   response.sendRedirect("login.jsp");
   }
   
   UserVO vo =(UserVO) session.getAttribute("user");
   String id = vo.getId();
   String name = vo.getName();
   
   %>
   <section>
   	<div align="center">
   		<h3>${sessionScope.user.id}(${sessionScope.user.name})님이 로그인 중입니다.</h3>
   		<a href="update.user">[정보수정]</a>
   		<a href="delete.user">[회원탈퇴]</a>   		
   	</div>
   </section> 
    
    <%@ include file="../include/footer.jsp" %>