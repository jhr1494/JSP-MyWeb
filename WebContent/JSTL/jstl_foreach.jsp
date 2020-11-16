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

	<h3>1~100까지 홀수 합</h3>
	<%
	int sum = 0;
	for(int i = 1; i <= 100; i+=2){
		sum += i;
	}
	%>
	결과 : <%=sum %>
	
	<hr/>
	
	<c:set var = "total" value="0"/>
	<c:forEach var="i" begin="1" end="100" step="2">
		
		${i }
		<c:set var="total" value="${total + i }"/>
	
	</c:forEach>
	<br>결과 : ${total }
	
	<hr/>
	<h3>구구단 3단 출력</h3>
	
	<c:forEach var="i" begin="2" end="9" step="1">
		3 X ${i } = ${3*i }<br/>
	</c:forEach>
	
	
	<hr/>
	<h3>2~9단 까지 모든 구구단 출력</h3>
	<c:set var="dan" value="2"/>
	<c:forEach var="dan" begin="2" end="9" step="1">
		<c:forEach var="hang" begin="2" end="9" step="1">
			${dan } X ${hang } = ${dan*hang }<br/>
		</c:forEach>
		<br>
	</c:forEach>
	
	
	<h3>향상된for문</h3>
	<%
	
	int[] arr = new int[] {1,2,3,4,5};
	
	for(int i : arr){
		out.println(i);
	}
	%>
	<hr/>
	
	<!-- set의 value는 단일값만 가능하므로 배열을 자바코드로 생성 
	el태그는 배열생성이 불가합니다  -->
	
	<!-- item은 배열이나 리스트를 받을수 있으며, item의 요소를 var에 대입합니다 
	varStatus는 item 요소의 index번호 및 주소를 받습니다. (.index : 인덱스번호)
	-->
	
	<!-- varStatus는 현재 for문의 상태값들을 확인 -->
	<c:set var="arr2" value="<%=new int[] {1,2,3,4,5} %>"/>
	<c:forEach var="i" items="${arr2 }" varStatus="s"> 
		${s.index }번의 값 : ${i }<br/>
		
		
	</c:forEach>
	
	

</body>
</html>