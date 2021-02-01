<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	int myoffset = 3;
	int mywidth = twelve - 2*myoffset;
	int formleft = 2 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	
<meta charset="UTF-8">
<title>회원별 매출 </title>
 	
<style type="text/css">
	.container{
	font-family: "Raleway", Sans-serif;
	}

	.form-group{ 
	margin-bottom : 3px; 
	}

	.article_title{
	padding-top: 80px;
	}
	.panel-heading {
	text-align: center;
	}
	.article_title{
	}
	.article_title h3{
	font-size:35px;
	font-weight:400;
	text-align:center;
	padding:0 0 20px 0
	}
	
	.article_title p{
	font-size:16px;
	color:#6f6f6f;
	line-height:23px;
	text-align:center;
	margin:20px 0 40px 0;
	}

	.panel, table{
	table-layout:fixed;	
	}
	.panel-body p{
	font-weight:bold;
	text-align:center;
	}	
	
</style>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="article_title">
			<h3>매출 현황</h3>
		</div>
	<div class="panel panel-default">
		<div class="panel-body">
		<p>회원별 매출 현황</p>
		<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>아이디</th>
						<th>총금액</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr>
						<c:if test="${not empty bean.id }">
						<td>${bean.id}</td>						
						</c:if>
						<c:if test="${empty bean.id  }"><td>탈퇴회원</td></c:if>
						<td>
							<fmt:formatNumber value="${bean.sumtotal}" pattern="###,###" />							
						</td>				
					</tr>
				</c:forEach>
		</table>
		<br><br>
		<p>월별 매출 현황</p>
		<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>월별</th>
						<th>누적건수</th>
						<th>총매출</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists1}">
					<tr>
						<td>${bean.or_date}</td>						
						<c:if test="${not empty bean.cnt}">
						<td>${bean.cnt}</td>						
						</c:if>
						<td>
							<fmt:formatNumber value="${bean.month_total}" pattern="###,###" />							
						</td>				
					</tr>
				</c:forEach>
		</table>		
		</div>
	</div>
	</div>
</body>
</html>