<%@page import="mypkg.utility.Paging"%>
<%@page import="mypkg.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2*myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
	int mysearch = 2;

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<link type="text/css" href="${contextPath }/css/pricelist.css" rel="stylesheet" />
	<script type="text/javascript">	
			function writeForm(){
				location.href='<%=NoForm%>prInsert';
			}
	</script>
<style type="text/css">

	.body{
	width:100%;
	}

	.panel {
    webkit-box-shadow: none;
    box-shadow: none;
	}
	
	.title, table {
	table-layout:fixed;
	}
	
	.title h3{
	padding-top:100px;
	font-size: 32px;
    color: #111111;
    text-align: center;
    line-height: 100%;
    padding-bottom: 20px;
	}
	.title p{
	font-size:16px;
	color:#6f6f6f;
	line-height:23px;
	text-align:center;
	margin:20px 0 40px 0;
	}
	
	.table {
	width: 100%;
 	padding: 0;
 	border-width: 0;
    webkit-box-shadow: none;
    box-shadow: none;
	border-collapse: collapse;
	}
	.table,tr,td,th{
	border:1px solid white;
    align:center;
	text-align: center;	
	}
	
	.table td img{
	max-width:100%;
	max-height:100%;
	border:1px solid white;
    border-collapse: collapse;	
	}

	.btn {
	cursor:pointer;
	background:#ffb400;
	color:#fff;
	cursor:pointer;
	font-size:13px;
	font-weight:400;	
	}

	.sbtn{
	align:center;
	list-style:none;
	position:relative;
	z-index:2;
	
	}	
	/* 버튼1 상세보기 */
	.r_btn1{
	height:60px;
	width:150px;	
	font-family: "Raleway", Sans-serif;	
	clear:both;
	background:#ffb400;
	color:#000;
	font-size:23px;
	text-align:center;
	border-radius:6px;
	padding:12px 14px 8px 14px;
	margin:0 0 5px 0px
	}
	.r_btn1 a:link { 
	color: black; 
	text-decoration: none;
	}
 	.r_btn1 a:visited { 
 	color: black; 
 	text-decoration: none;
 	}
	.r_btn1 a:hover {
	text-decoration: none;
	}
	.r_btn1:hover {
	cursor:pointer;
	background:#ff9600; 	
	}
		
	/* 버튼2 이용안내 */
	.r_btn2{
	height:60px;
	width:150px;
	font-family: "Raleway", Sans-serif;
	background:#696969;
	color:#fff;
	font-size:23px;
	text-align:center;
	border-radius:6px;
	padding:12px 14px 8px 14px;
	margin:0 0 5px 0px
	}
	.r_btn2 a:link{
	color: white; 
	text-decoration: none;
	}
	.r_btn2 a:visited{
	color: white; 
	text-decoration: none;
	}
	.r_btn2 a:hover{
	color:black;
	text-decoration:none;
	cursor:pointer;
	background:#5a5a5a;
	}
	.r_btn2:hover{
	cursor:pointer;
	background:#5a5a5a;
	}	
	
	</style>
<script type="text/javascript">
</script>	
	
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>"> 
		<div class="title">
			<h3 align="center" >상품 목록</h3>
			<p>상품 목록 페이지입니다.</p>
		</div>
	<div class= "panel"> 	
		<table class="table table-condensed" style="table-layout:fixed;">
			<colgroup>
    		<col style="width: 14%">
    		<col style="width: 14%">
    		<col style="width: 14%">
    		<col style="width: 14%">
       		<col style="width: 14%">
    		<col style="width: 14%">
    		<col style="width: 14%"> 		
			</colgroup>

		<c:forEach var="bean" items="${requestScope.lists}">				
			<tr>
				<td>${bean.pnum}</td>
				<td>${bean.item}</td>
				<td>${bean.category}</td>
				<td>${bean.seatnum}</td>
				<td>${bean.ptype}</td>
				<td>${bean.hours}시간</td>
				<td>${bean.price}원</td>
			</tr>
			<tr height="350">
				<td colspan="7">
			<div class="pictures" style="position: relative; z-index: 1;">	
					<c:if test="${empty bean.pic}">
						<img src="<%=uploadedFolder%>${bean.pic}" class="img-thumbnail" alt="no image">
					</c:if>						
					
					<c:if test="${applicationScope.debugMode == true}">
						디버그 모드가 true이면 보입니다.<br>
						${applicationScope.uploadedPath}/${bean.pic}
					</c:if>
					
					<c:if test="${not empty bean.pic}">
						<img src="${applicationScope.uploadedPath}/${bean.pic}"
							class="img-thumbnail" alt="${bean.pic}">
					</c:if>
			</div>
			<div class="sbtn">	
				<ul>
					<li class="r_btn1"><a href="<%=NoForm%>prDetail&pnum=${bean.pnum}&${requestScope.parameters}" target="_self">상세보기</a></li>
					
					<li class="r_btn1"><a href="<%=NoForm%>prFee" target="_self">이용안내</a></li>	
				</ul>	
			</div>
			<c:if test="${whologin == 2}">
			<form class="sbtn" 
			role="form" name="myform" action="<%=YesForm%>" method="get">
				<input type="hidden" name="command" value="prList">
				<ul>
					<li class="r_btn2" type="button" onclick="writeForm();">상품 등록</li>
				</ul>
			</form>
			<div class="sbtn">	
			<ul>
				<li class="r_btn2">
				<a href="<%=NoForm%>prUpdate&pnum=${bean.pnum}&${requestScope.parameters}">
					수정
				</a>			
				</li>
				<li class="r_btn2">
				<a href="<%=NoForm%>prDelete&pnum=${bean.pnum}&${requestScope.parameters}">
					삭제
				</a>			
				</li>
			</ul>
			</div>	
			
			</c:if>
										
		</td>
		</tr>			
		</c:forEach>	
			
		</table>
	</div>
	</div>
</body>
</html>