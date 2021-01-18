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
<script type="text/javascript">	
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
	max-width:100%;
	max-height:100%;
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
/*	z-index: 2;
	left: -15px;  
	top: -480px;	*/
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
			<h3 align="center">좌석 목록</h3>
			<p>좌석 목록 페이지입니다.</p>
		</div>
		
	<div class="panel">
	
		<table class="table table-condensed" style="table-layout:fixed; position:relative; width:100%;">
			<colgroup><col style="width: 100%"></colgroup>

		<c:forEach var="bean" items="${requestScope.lists}">				
			<c:if test="${bean.p_seat eq 'A01' or bean.p_seat eq 'R01'}">
				<tr>
					<td style="font-size:12pt">${bean.p_type}</td>
				</tr>
				<!-- 이미지 -->
				<tr height="350">
					<td colspan="7" style="padding-bottom:50px; position:relative; z-index: 1;">
					<c:if test="${empty bean.p_pic}">
						<img src="<%=uploadedFolder%>/room02.png" class="img-thumbnail" alt="no image" >
					</c:if>						

					<c:if test="${applicationScope.debugMode == true}">
						디버그 모드가 true이면 보입니다.<br>
						${applicationScope.uploadedPath}/${bean.p_pic}
					</c:if>
					
					<c:if test="${not empty bean.p_pic}">
						<img src="${contextPath}/upload/${bean.p_pic}"
							class="img-thumbnail" alt="${bean.p_pic}">
					</c:if>
						<a href="<%=NoForm%>prDetail&p_seat=${bean.p_seat}" target="_self">
						<button type="button" class="btn btn-warning">상세보기</button>
						</a>						
						<a href="<%=NoForm%>prFee" target="_self">
						<button type="button" class="btn btn-default">이용안내</button>
						</a>
				</tr>			
		</c:if>
		</c:forEach>
			

		</table>
		<br><br><br>
		</div>
	</div>
</body>
</html>