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
	font-family: "Raleway", Sans-serif;
	}
	.article_title h3{
	font-size:35px;
	font-weight:400;
	text-align:center;
	padding:0 0 20px 0
	}
	
	.article_title p{
	font-family: "Raleway", Sans-serif;
	font-size:16px;
	color:#6f6f6f;
	line-height:23px;
	text-align:center;
	margin:20px 0 40px 0;
	}

	.panel, table{
	table-layout:fixed;	
	}	
	
</style>
</head>
<body>

	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="article_title">
			<h3>회원별 매출 현황</h3>
			<p>회원별 매출 현황 페이지입니다.</p>
		</div>
	<div class="panel panel-default">
		<div class="panel-body">
		<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>아이디</th>
						<th>총금액</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr>
						<td>${bean.id}</td>						
						<td>
							<fmt:formatNumber value="${bean.sumtotal}" pattern="###,###" />							
						</td>				
					</tr>
				</c:forEach>
		</table>		
		</div>
	</div>
	</div>
</body>
</html>