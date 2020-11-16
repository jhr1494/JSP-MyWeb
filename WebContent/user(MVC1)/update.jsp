<%@page import="com.myweb.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
	//이 페이지에 진입했을 때 비밀번호를 제외한 회원의 정보를 input 태그에 처리합니다.
	UserVO vo = (UserVO)session.getAttribute("user"); // user 이름으로 세션 저장한걸 가져옴
	String id = vo.getId();
	String name = vo.getName();
	String email = vo.getEmail();
	String address = vo.getAddress();

	// readonly 는 태그의 릭기만 가능하게 하는 속성
 %>
 
 
 
<section>
	<div align="center">
		<h2>회원정보 연습</h2>
		<hr/>
		<!--  수정 경로 -->
		<form action="update_ok.jsp" method="post" name="regForm">
		
			<table>
				<tr>
					<td>아이디 </td> <!-- 아이디는 수장되면 안됨.  disabled 는 요청으로 값이 안넘어감 readonly는 값이 넘어감-->
					<td><input type="text" name="id" value="<%= id %>" readonly ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwCheck"></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" name="name" value= "<%=name%>"></td>
				</tr>
				<tr>
					<td>이메일: </td>
					<td><input type="text" name="email" value="<%= email%>"></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input type="text" name="address" value="<%= address%>" ></td>
				</tr>
			</table>
			<input type="button" value="수정" class="btn btn-default" onclick="check()">
			<%-- on으로 시작하는건 동작을 의미하는 이벤트 --%>  
			<input type="button" value="취소" class="btn btn-primary" onclick="history.go(-1)">
			<%-- 온클릭안에는 자바 스트립트로 인식함. //뒤로가기  --%>
		</form>
	</div>
</section>
<script> 
function check(){
	//form 태그는 유일하게 document.form이름.이름...  접근이 가능합니다.
	if(document.regForm.id.value.length < 4 ){ //공백 = ''  ,  4자리 이상
		alert('아이디는 필수입니다');
		return; //함수종료
	}else if (document.regForm.pw.value < 4){
		alert("비밀번호는 4자리 이상입니다");
		return;
	}else if (document.regForm.pw.value != document.regForm.pwCheck.value ){
		alert("비밀번호 확인란을 확인하세요");
		return;
	}else if(document.regForm.name.value == ''){
		alert("이름은 필수입니다");
		return;
	
	}else{
		//submit()은 자바스크립트의 서브밋기능 
		document.regForm.submit();
	}
}
</script>


<%@ include file="../include/footer.jsp"%>