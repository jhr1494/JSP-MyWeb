<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div align="center">
		<h2>기존 비밀번호를 입력해주세요</h2>
		<form action="delete_ok.jsp" method="post">
			비밀번호:<input type="password" name="pw">
			<input type="submit" value="확인" class="btn btn-danger" >
		</form>
	</div>
</section>

<%@ include file="../include/footer.jsp" %>