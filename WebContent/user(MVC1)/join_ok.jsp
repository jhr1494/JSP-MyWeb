<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id =request.getParameter("id");
	String pw =request.getParameter("pw");
	String name =request.getParameter("name");
	String email =request.getParameter("email");
	String address =request.getParameter("address");

	//아이디 중복 체크 후 insert들어가야함.--UserDAO 클래스

	
	//1. UserDAO 객체 생성
	 UserDAO dao = UserDAO.getInstance(); 
	
	//2. 중복검사
	int result = dao.checkId(id);
	
	
	if(result == 1 ){//중복
		//MVC 1방식 --(좋은 방법은 아니라고함. 예제를 보여주기위한 사용)
		%>
		<script>
			alert("아이디 중복입니다");
			history.go(-1); // 뒤로가기
		</script>
		
		<%
	}else{
		UserVO vo = new UserVO(id, pw, name, email, address, null);
		 int result2 = dao.join(vo);
		
		 if(result2 == 1){ //성공
			 %>
			 <script>
			 	alert("가입을 축하합니다.");
			 	location.href = "login.jsp";
			 </script>
			 
			 <%
			 
		 } else{ //실패
			 %>
			 <script>
			alert("가입에 실패했습니다. 다시 시도하세요.")
			location.href = "join.jsp";
			</script>
			 <%
		 }
	}
	
	

	
	
	
%>