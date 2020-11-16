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
	
	<!--변수 선언 (el로 참조가 가능합니다)-->
	<!-- var : (변수이름) value : (변수의 값 (문자열)) -->
	<c:set var="num1" value="1"/> 
	
	<!-- 변수출력  : el태그를 참조하여 사용이 가능합니다(단, c:set으로 만들어져야합니다)-->
	<c:out value="${num1}"/>
	
	<hr>
	
	<%if(true){%>
	무조건 실행되는 문장<br/>
	<%} //아래와 동일형식이다 %>
	
	<!-- c:if test="(조건)" -->
	<!-- test에는 조건이 들어갑니다 -->
	<c:if test="true">
		무조건 실행되는 문장<br/>
	</c:if>
	
	<hr>
	
	<c:if test="${param.name eq	'홍길동' }"> <!-- param으로 넘어온 name이 홍길동과 같다면 -->
		이름이 홍길동 입니다<br/>
	</c:if>
	
	<c:if test="${param.name eq	'이순신' }"> <!-- param으로 넘어온 name이 이순신과 같다면 -->
		이름이 이순신 입니다<br/>
	</c:if>
	
	<% //위의코드를 java로 작성할경우
	if(request.getParameter("name").equals("홍길동")){ %>
		이름이 홍길동 입니다
	<%} %>
	
	<hr/>
	
	<!-- age파라미터 값이 20이상이면 성인입니다, 20미만이면 미성년자 입니다 -->
	<% //java사용
	if(Integer.parseInt(request.getParameter("age")) >= 20){ %>
		성인입니다
	<%} %>
	
	
	el태그만 사용 : ${param.age >= 20 ? '성인입니다' : '미성년자입니다' }<br/>
	jstl사용 : 
	<c:if test="${param.age >= 20 }">
		성인입니다<br/>
	</c:if>
	
	<c:if test="${param.age < 20 }">
		미성년자 입니다<br/>
	</c:if>
		

</body>
</html>