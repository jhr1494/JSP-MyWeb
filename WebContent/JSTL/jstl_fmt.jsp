<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--
	 Formatting의 4가지 표현형식
	 - formatNumber : 숫자표현 자릿수
	 - formetDate : 날짜표현 형식
	 - parseDate : 문자를 Date형식으로 변환
	 - parseNumber : 문자형식을 숫자형식으로 변환
	 -->
	<h2>formatNumber, formetDate, parseDate, parseNumber</h2>
	
	<h3>formatNumber -> 숫자의 자릿수를 지정합니다</h3>
	
	<c:set var ="d01" value="2020"/>
	<fmt:formatNumber var="v01" value="${d01 }" pattern="000000"/>
	<fmt:formatNumber var="v02" value="${d01 }" pattern="0000.00"/>
	
	${v01 }<br/>
	${v02 }<br/>
	
	<hr/>
	
	<h3>formetDate -> 날짜형을 지정된 날짜형태로 변경</h3>
	<c:set var="d02" value="<%=new Date() %>"/>
	<fmt:formatDate var="v03" value="${d02 }" pattern="yyyyMMdd HHmmss"/>
	<fmt:formatDate var="v04" value="${d02 }" pattern="yyyy년 MM월 dd일 "/>
	<fmt:formatDate var="v05" value="${d02 }" pattern="yyyy-MM-dd HH:mm:ss"/>
	${v03 }<br/>
	${v04 }<br/>
	${v05 }<br/>
	
	<hr/>
	
	<h3>parseDate -> 문자를 날짜(java.util.Date)로 형변환</h3>
	<!-- to_date와 비슷 -->
	
	<c:set var="d03" value="2020/11/04"/>
	<fmt:parseDate var="v06" value="${d03 }" pattern="yyyy/MM/dd" />
	
	<c:set var="d04" value="2020-11-04 23:12:34"/>
	<fmt:parseDate var="v07" value="${d04 }" pattern="yyyy-MM-dd HH:mm:ss" />
	
	
	${v06 }<br>
	${v07 }<br>
	
	
	<hr/>
	
	<h3>parseNumber -> 날짜를 밀리초로 변경 가능(Date().getTime()과 동일)</h3>
	<c:set var="d05" value="<%=new Date() %>"/>
	<fmt:parseNumber var="v08" value="${d05.time }"/>
	
	${v08 }<br/>
	<%=new Date().getTime() %>
	
	<hr/>
	<h3>parseNumber -> 문자를 숫자형식(int)으로 형변환</h3>
	
	<fmt:parseNumber var="d06" value="1,100.00" pattern="0,000.00"/>
	${d06 }<br/>
	


</body>
</html>

















































