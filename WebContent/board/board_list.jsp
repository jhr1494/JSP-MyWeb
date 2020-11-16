<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<%@ include file="../include/header.jsp" %>

<style >
.btn {
          
       border: 0; 
       border-radius: 0; /*윤곽 0*/
       padding: 5px 10px; 
       margin: 20px 0px;
     }

</style>

<!-- header.jsp (<body>) ~ footer.jsp(</body>)  -->

	<div class="container">
		<h3>My Web게시판</h3>
		
		<!-- ()개씩 보기 선택창 -->
		<div align="right">
		<select onchange="change(this)" >
			<option value="10" ${pageVO.amount == 10? 'selected' : '' }>10개씩 보기</option>
			<option value="20" ${pageVO.amount == 20? 'selected' : '' }>20개씩 보기</option>
			<option value="50" ${pageVO.amount == 50? 'selected' : '' }>50개씩 보기</option>
			<option value="100" ${pageVO.amount == 100? 'selected' : '' }>100개씩 보기</option>
		</select>
		</div>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>

			<c:forEach var="vo" items="${list }"  >
			<tbody>
				<tr>
					<td>${vo.bno }</td>
					<td>${vo.writer }</td>
					<td><a href="content.board?bno=${vo.bno} ">${vo.title }</a></td>
					<td><fmt:formatDate value="${vo.ragdate }" pattern="yyyy년 MM월 dd일"/> </td>
					<td>${vo.hit }</td>
				</tr>
			</tbody>
			</c:forEach>
			
			<tbody>
				<tr>
					<td colspan="5" align="center">
	               			<ul class="pagination pagination-sm">
                        		
                        		<!-- 2. 이전버튼 활성화 여부 -->
                        		<c:if test="${pageVO.prev }">
                        			<li><a href="list.board?pageNum=${pageVO.startPage-1 }&amount=${pageVO.amount}">
                        			이전</a></li>
                        		</c:if>
                        		
                        		
                        		<!--1. 페이지 번호처리 , li엑티브 여부-->
                        		<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
                        			<li class="${num eq pageVO.pageNum ? 'active' : '' }">
                        			<a href="list.board?pageNum=${num }&amount=${pageVO.amount}">
                        			${num }</a></li>
                        			</c:forEach>
                        			
                        		
                        		<!-- 3. 다음버튼 활성화 여부 -->	
                        		<c:if test="${pageVO.next }">
                        			<li><a href="list.board?pageNum=${pageVO.endPage+1 }&amount=${pageVO.amount}">
                        			다음</a></li>
                    				</ul>
                    			</c:if>
                    			
                    			
					<input type="button" value="글 작성" class="btn btn-default pull-right" onclick="location.href= 'write.board'">
					
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>
	
	
	<script>
		function change(a) {
			//console.log(a)
			//console.log(a.value)
			location.href = "list.board?pageNum=1&amount=" + a.value;
		}

	</script>
<%@ include file ="../include/footer.jsp" %>








