<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
	<div align="center">
		<h2>회원가입 연습</h2>
		<hr/>
		
		<form action="joinFrom.user" method="post" name="regForm">
		
			<table>
				<tr>
					<td>아이디 </td>
					<td><input type="text" name="id" placeholder="4글자 이상"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwCheck" ></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" name="name" ></td>
				</tr>
				<tr>
					<td>이메일: </td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>주소:</td>
					<td><input type="text" name="address" ></td>
				</tr>
			</table>
			<br/>
			<p>${msg }</p>			
			<input type="button" value="가입" class="btn btn-default" onclick="check()">
			<%-- on으로 시작하는건 동작을 의미하는 이벤트 --%>  
			<input type="button" value="로그인" class="btn btn-primary" onclick="location.href='login.jsp' ">
			
		</form>
	</div>
</section>

<script> 
// 반환유형이 없음
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

<%@ include file="../include/footer.jsp" %>
