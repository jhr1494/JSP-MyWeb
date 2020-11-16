<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to MyWorld</title>

	<!--  link 태그는 외부  css파일을 참조하는 태그 - , 상대경로를 절대 경로로 바꿈->
	    <!-- Bootstrap Core CSS -->
	    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
	    <!-- Custom CSS -->
	    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">
	    <!-- Fonts -->
	    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
		
	
	<!--   스크립트는 외부 js 파일을 참조하는 태그 -->
		<!-- jQuery -->
	    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>
	    <!-- Bootstrap Core JavaScript -->
	    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>



    
    
</head>

<body>
	<!-- header -->
	<div class="brand">My Web</div>        
    <div class="address-bar">Welcome to MyWorld</div>
		
    
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	
                    <li>
                     	<!-- 절대경로로 적어주기 -->
                        <a href="<%=request.getContextPath() %>">HOME</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/member/member.jsp">Member</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/board/list.board">BOARD</a>
                    </li>
                    
                    
                    <c:choose>
                    	<c:when test="${sessionScope.user == null}">
                    	     <li>
		                        <a href="${pageContext.request.contextPath}/user/login.user">LOGIN</a>
		                    </li>
		                    <li>
		                        <a href="${pageContext.request.contextPath}/user/join.user" style="color:red">JOIN</a>
		                    </li>
		                  </c:when>
                    	<c:otherwise>
                    		<li>
		                        <a href="${pageContext.request.contextPath}/user/logout.user">LOGOUT</a>
		                    </li>
		                    <li>
		                        <a href="${pageContext.request.contextPath}/user/mypage.user">MYPAGE</a>
		                    </li>
                    	</c:otherwise>
                    </c:choose>
<%--
                    <% if(session.getAttribute("user") == null){  %>
                    <% } else{ %>
                    <% } %>
     --%>         
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->