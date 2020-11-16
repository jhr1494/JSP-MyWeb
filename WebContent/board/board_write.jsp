<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style >
.btn {
          
       border: 0; 
       border-radius: 0; /*윤곽 0*/
       padding: 5px 10px; 
       margin: 20px 0px;
     }

</style>


<div align="center" class="div_center">
	<h3>게시판 글 작성 페이지</h3>
	<hr>
	
	<form action="regist.board" method="post">
		<table border="1" width="500">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" value="${sessionScope.user.id }" size="10" required readonly>
				</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" required  ><!-- pattern="[A-Za-z가-힣0-9]{3}" -->
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성 완료">
					<input type="button" value="목록" onclick="location.href='list.board'"> <!-- jsp페이지로 바로 전환이 아닌 컨트롤러(서블릿)으로 이동 -->        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>


<%@ include file ="../include/footer.jsp" %>