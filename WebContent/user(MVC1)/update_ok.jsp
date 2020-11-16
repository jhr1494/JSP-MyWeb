
<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

/*
1. 폼데이터를 받습니다.
2. DAO에 update() 메서드를 생성하고, 업데이트 구문을 실행
3. 수정 성공시 "회원정보가 수정되었습니다" 출력후 마이페이지로 이동
	실페 시 "회원정보 수정에 실패했습니다." 출력후 마이페이지로 이동
*/

	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");

	//VO 포장
	UserVO vo = new UserVO(id,pw,name,email, address, null);
	//DAO 생성
	UserDAO dao = UserDAO.getInstance();
	int result = dao.update(vo);
	
	if(result == 1){ // 성공
		//성공시 세션값이 같이 변경
		session.setAttribute("user", vo);
		%>
		<script>
			alert("회원정보가 수정되었습니다");
			location.href = "mypage.jsp";
		</script>
		<% 
	}else{ //실패
		%>
			<script>
			alert("회원정보 수정에 실패했습니다");
			location.href = "mypage.jsp";
		</script>
		<%
	}
	
	

%>














