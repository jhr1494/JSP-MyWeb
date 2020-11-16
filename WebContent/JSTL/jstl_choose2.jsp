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

	<!-- 
	choose태그를 이용해서 90이상이면 A, 80이상 B, 70이상 C, 나머지 F
	90점 이상일 때는 중첩 if구문의 형태로 A+, A로 나누어 표현
	 -->
	 
	 <c:choose>
	 	<c:when test="${param.score > 100 }">
	 		<script>
	 		 alert("100점 을 초과하였습니다")
	 		 location.href="jstl_form.jsp"
	 		</script>
	 	</c:when>
	 	
	 	<c:when test="${param.score >= 90 }">
	 		<c:choose>
	 		<c:when test="${param.score >= 95 }">
	 			<h4>A+ 학점입니다</h4><br/>
	 		</c:when>
	 		<c:otherwise>
	 			<h4>A 학점 입니다</h4><br/>
	 		</c:otherwise>
	 		</c:choose>
	 	</c:when>
	 	
	 	<c:when test="${param.score >= 80 }">
	 		<h4>B 학점입니다</h4><br/>
	 	</c:when>
	 	<c:when test="${param.score >= 70 }">
	 		<h4>C 학점입니다</h4><br/>
	 	</c:when>
	 	<c:otherwise>
	 		<h4>F 학점입니다</h4><br/>
	 	</c:otherwise>
	 
	 </c:choose>

</body>
</html>