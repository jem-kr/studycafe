<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% int twelve = 12 ; %>
<c:set var="twelve" value="12" />

<!-- whologin 변수는 로그인 상태를 저장하고 있는 변수 정보이다.-->
<c:set var="whologin" value="0" />

<c:if test="${ empty sessionScope.loginfo}"><!-- 로그인 안함 -->
	<!-- 어떤 사람도 로그인을 안했으면 0  -->
	<c:set var="whologin" value="0" />
</c:if>

<c:if test="${ not empty sessionScope.loginfo}"><!-- 로그인 함 -->
	<c:if test="${ sessionScope.loginfo.id == 'admin'}">
		<!-- 관리자 : 2  -->
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${ sessionScope.loginfo.id != 'admin'}">
		<!-- 사용자 : 1  -->
		<c:set var="whologin" value="1" />
	</c:if>
</c:if>


<%!
	String YesForm = null ;
	String NoForm = null ;
%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/studycafe";  //서블릿에 정의되어 있음.
	//폼 태그에서 사용할 변수
	YesForm = contextPath + mappingName ;
	//폼이 아닌 곳에서 사용할 변수
	NoForm = contextPath + mappingName + "?command=" ;		
%>
<%	 
	//파일 업로드 관련
	String myurl = request.getRequestURL().toString() ;
	String uri = request.getRequestURI() ;
	int idx = myurl.indexOf( uri ) ;	
	//웹서버에 올릴 이미지의 저장 경로 
	String uploadPath = "/upload" ;//개발자가 임의 지정 가능
	String uploadedFolder 
		= myurl.substring(0, idx) + contextPath + uploadPath ;	
	String realPath = application.getRealPath( uploadPath ) ;
%>
<%
	/* out.print( "YesForm : " + YesForm + "<br>") ;
	out.print( "NoForm : " + NoForm + "<br>") ;
	out.print( "myurl : " + myurl + "<br>") ;
	out.print( "uploadedFolder : " + uploadedFolder + "<br>") ;
	out.print( "realPath : " + realPath + "<br>") ; */
%>
<%!
	String MakeCommand(String ... args){
		if( args.length == 0 ){
			return YesForm  ;
		}else if( args.length == 1 ){
			return YesForm + "?command=" + args[0]   ;	
		}else{
			String imsi = args[1] ;
			return YesForm + "?command=" + args[0] + "&" + imsi  ;
		}
	}
%>

<c:set var="contextPath" value="<%=contextPath%>" scope="application"/> 

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="favicon.ico">
		<title>StudyCafe HTML</title>
		<!-- Bootstrap core CSS -->
		<link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<link href="${contextPath}/css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
  		<style type="text/css">
  			.btn{
  				right:10px;
  				align-items: flex-end;
  			}
  			
  			
  		</style>
  		<script type="text/javascript">
	  		$(document).ready(function(){
	  		});
  		</script>
	</head>
	<body id="page-top">
		<!-- Navigation -->
		<!-- 네비바 상단 고정 -->
		<nav class="navbar navbar-inverse navbar-fixed-top" >
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header page-scroll">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" >
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-logo navbar-brand page-scroll" href="<%=NoForm%>main">
						<img src="${contextPath}/images/9_logo.png"  alt="thatstudy logo" >
					</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li>
							<a class="page-scroll" href="<%=NoForm%>about">소개</a>
						</li>
						<li>
							<li class="dropdown">
							<a class="dropdown-toggle page-scroll" href="#product"
							data-toggle="dropdown">시설안내</a>
							<ul class="dropdown-menu">
								<li>
									<a href="<%=NoForm%>prFac">시설 소개</a>
								</li>
								<li>
									<a href="<%=NoForm%>prList">상품 목록</a>
								</li>
								<li>
									<c:if test="${whologin == 2}">
										<a href="<%=NoForm%>prPrice">상품 매출</a>
									</c:if>	
								</li>
								<li>
									<a href="<%=NoForm%>prFee">이용 요금</a>
								</li>
								<li>
									<c:if test="${whologin == 2}">
										<a href="<%=NoForm%>prInsert">상품 등록</a>
									</c:if>	
								</li>
							</ul>
						</li>
						<li>
							<li class="dropdown">
							<a class="dropdown-toggle page-scroll" href="#notice"
							data-toggle="dropdown">공지사항</a>
							<ul class="dropdown-menu">
								<li>
									<c:if test="${whologin == 2}">
										<a href="<%=NoForm%>noInsert">공지사항 등록</a>
									</c:if>	
								</li>
								<li>
									<a href="<%=NoForm%>noList">공지사항 목록</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle page-scroll" href="member_info"
							data-toggle="dropdown">회원정보</a>
							<ul class="dropdown-menu">
								<li>
									<c:if test="${whologin == 0}">
										<a href="<%=NoForm%>meLogin">로그인</a>
									</c:if>		
								</li>
								<li>
									<c:if test="${whologin != 0}">
										<a href="<%=NoForm%>meLogout">로그아웃</a>
									</c:if>		
								</li>
								<li>
									<c:if test="${whologin == 0}">
										<a href="<%=NoForm%>meInsert">회원가입</a>
									</c:if>	
								</li>
								<li>
									<c:if test="${whologin != 0}">
										<a href="<%=NoForm%>meUpdate&id=${sessionScope.loginfo.id}">회원정보수정</a>
									</c:if>	
								</li>
								<li>
									<c:if test="${whologin != 0}">
										<a href="<%=NoForm%>meDelete&id=${sessionScope.loginfo.id}">회원탈퇴</a>
									</c:if>	
								</li>
								<li>
									<c:if test="${whologin == 2}">
										<a href="<%=NoForm%>meList">회원목록보기</a>
									</c:if>	
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle page-scroll" href="#booking"
							data-toggle="dropdown">예약하기</a>
							<ul class="dropdown-menu">
								<li>
									<c:if test="${whologin == 1}">
										<a href="<%=NoForm%>bkInsert">예약 하기</a>
									</c:if>		
								</li>
								<li>
									<c:if test="${whologin != 0}">
										<a href="<%=NoForm%>bkList">예약내역 보기</a>
									</c:if>		
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a class="dropdown-toggle page-scroll" href="#cart" 
							data-toggle="dropdown">장바구니</a>
							<ul class="dropdown-menu">
								<li>
									<c:if test="${whologin == 1}">
										<a href="<%=NoForm%>cartList">장바구니 목록</a>
									</c:if>	
								</li>
								<li>
									<c:if test="${whologin == 1}">
										<a href="<%=NoForm%>bkList">구매 내역</a>
									</c:if>	
								</li>
							</ul>
						</li>
						<li>
							<c:if test="${whologin == 0}">
								<a href="<%=NoForm%>meLogin">
								<button type="button" class="btn btn-default btn-sm">
			        		 		 <span class="glyphicon glyphicon-user"></span> 로그인 
			     		   		</button>
			     		   		</a>
			     		   </c:if>
			     		   <c:if test="${whologin != 0}">
								<button type="button" class="btn btn-default btn-sm">
			        		 		 <span class="glyphicon glyphicon-user"></span> ${sessionScope.loginfo.name}님  
			     		   		</button>
			     		   </c:if>
			        	</li>
					</ul>
				<!-- /.navbar-collapse -->
				</div>
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/SmoothScroll.js"></script>
		<script src="js/theme-scripts.js"></script>
	</body>
</html>