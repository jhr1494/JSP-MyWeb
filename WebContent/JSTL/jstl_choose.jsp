<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test = "${param.name eq '홍길동' }">
			<h4>홍길동 입니다</h4>
		</c:when>
		<c:when test = "${param.name eq '이순신' }">
			<h4>이순신 입니다</h4>
		</c:when>
		<c:otherwise>
			<h4>홍길동, 이순신 아닙니다</h4>
		</c:otherwise>
		
	</c:choose>
	
	<!-- 20세 이상 20미만 성인, 미성년자 -->
	<c:choose>
		<c:when test="${param.age >= 20 }">
			<h4>성인입니다</h4>
		</c:when>
		<c:otherwise>
			<h4>미성년자 입니다</h4>
		</c:otherwise>
	</c:choose>

</body>
</html>