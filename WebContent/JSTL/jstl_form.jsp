<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>IF절 확인하기</h2>
	
	<form action="jstl_if.jsp">
		이름 : <input type="text" name="name">
		나이 : <input type="text" name="age">
		<input type="submit" value="확인">
	</form>
	
	<h2>choose절 확인하기</h2>
	<form action="jstl_choose.jsp">
		이름 : <input type="text" name="name">
		나이 : <input type="text" name="age">
		<input type="submit" value="확인">
	</form>
	
	<h2>choose절 확인하기 2</h2>
		<form action="jstl_choose2.jsp">
			점수 : <input type="text" name="score"><br/>
			<input type="submit" value="확인">
		
		</form>

</body>
</html>