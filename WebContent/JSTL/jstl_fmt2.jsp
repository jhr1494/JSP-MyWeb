<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 태그라이브러리 선언(필수!) -->
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>아래값들을 2020년 05월 03일 형식으로 변경해서 출력</h2>
	
	<c:set var="TIME_A" value="2020-05-03" />
	<c:set var="TIME_B" value="2020/05/03" />
	<c:set var="TIME_C" value="2020-05-03 21:30:22" />
	<c:set var="TIME_D" value="<%=new Date() %>" />
	
	<!-- 문자형식을 date형식으로 변경 -->
	<fmt:parseDate var="TIME_A_f" value="${TIME_A }" pattern="yyyy-MM-dd"/>
	<fmt:parseDate var="TIME_B_f" value="${TIME_B }" pattern="yyyy/MM/dd"/>
	<fmt:parseDate var="TIME_C_f" value="${TIME_C }" pattern="yyyy-MM-dd HH:mm:ss"/>
	
	<!-- date형식을 지정형식으로 포맷 -->
	<fmt:formatDate var="TIME_A_fmt" value="${TIME_A_f }" pattern="yyyy년 MM월 dd일"/>
	<fmt:formatDate var="TIME_B_fmt" value="${TIME_B_f }" pattern="yyyy년 MM월 dd일"/>
	<fmt:formatDate var="TIME_C_fmt" value="${TIME_C_f }" pattern="yyyy년 MM월 dd일"/>
	<fmt:formatDate var="TIME_D_fmt" value="${TIME_D }" pattern="yyyy년 MM월 dd일"/>
	
	${TIME_A_fmt }<br/>
	${TIME_B_fmt }<br/>
	${TIME_C_fmt }<br/>
	${TIME_D_fmt }<br/>

</body>
</html>