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
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	
	
	<form action="update.board" method="post">
	<!-- input값을 숨겨서(화면에 비노출)보내는 hidden  --- disabled태그의 경우 파라미터값을 꼭 보내야할 경우-->
	<!-- form안에서 화면에 보이지는 않지만, 반드시 넘겨줘야 되는 값을 숨겨서 보낼때 hidden을 사용합니다. -->
	
	<input type="hidden" name="bno" value="${vo.bno }">
	<input type="hidden" name="writer" value="${vo.writer }">
		
		<table border="1" width="500">
			
			<tr>
				<td>글 번호</td>
				<td><input type="text"  name="bno" value="${vo.bno }" disabled></td>
				<!-- 수정을 불가하게하는 readonly, disabled 차이
					disabled : 사용을 아예 할 수 없음 -- 값이 안넘어감(아예 사용자체를 할수 없음)
					readonly : 읽기만 가능 -- 값이 넘어감(사용 가능)
				-->
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.writer }" disabled></td>

			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="title" value="${vo.title }" re>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content">${vo.content }
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" >&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.board'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>
<%@ include file ="../include/footer.jsp" %>