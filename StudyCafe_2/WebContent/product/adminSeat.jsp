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
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<link type="text/css" href="${contextPath }/css/pricelist.css" rel="stylesheet" />


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
	
	.title h2{
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
	frame:void;
	width: 100%;
 	padding: 0;
 	border-width: 0;
    webkit-box-shadow: none;
    box-shadow: none;
	border-collapse: collapse;
	padding-bottom:50px;
	}
	.table,tr,td,th{
	border:1px solid white;
    align:center;
	text-align: center;	
	}
	
	.table td img{
	max-width:55%;
	max-height:50%;
	border:1px solid white;
    border-collapse: collapse;	
	}


	.button {
	WIDTH: 85pt; 
	HEIGHT: 40pt; 
	font-size:1.8em
	}
	
	.btn{
	WIDTH: 85pt; 
	HEIGHT: 40pt; 
	font-size:1.8em;
	float: center;
	position: relative;
	}
</style>
<script type="text/javascript">	

	
</script>
<meta charset="UTF-8">
<title>좌석 목록</title>
</head>
<body>
<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>"> 
		<div class="title">
			<h2 align="center">좌석 관리</h2>
			<p>관리자용 좌석 수정 및 삭제 가능 페이지입니다.</p>
		</div>
	<div class="panel">
	<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th>좌석타입</th>
					<th>좌석번호</th>
					<th>이용가격</th>
					<th>수정</th>
					<th>삭제</th>					
				</tr>
			</thead>
			<tr>
							
		<c:forEach var="bean" items="${requestScope.lists}">		
		<tr>
			<td>${bean.p_type}</td>
			
			<td>
				<a href="<%=NoForm%>prDetail&p_seat=${bean.p_seat}" target="_self">
				${bean.p_seat}
				</a>
			</td>
			
			<td>${bean.p_price}</td>
			
			<td>
				<a href="<%=NoForm%>prUpdate&p_seat=${bean.p_seat}" target="_self">
					수정
				</a>	
			</td>
			
			<td>
				<a href="<%=NoForm%>prDelete&p_seat=${bean.p_seat}" target="_self">
					삭제
				</a>	
			</td>
		</tr>	
		</c:forEach>
	</table>
	<br><br><br>
	</div>
	</div>
</body>
</html>