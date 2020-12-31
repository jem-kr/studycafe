<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>  
<%@page import="java.io.File"%> 
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
<meta charset="UTF-8">
<title>상품 정보 수정</title>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="article_title">
			<h3>상품 정보 수정</h3>
			<p>관리자 상품 정보 수정 페이지입니다.</p>
		</div>
	<div class="panel panel-default">

		<div class="panel-body">
		
			<form class="form-horizontal" role="form" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
				<input type="hidden" name="command" value="prUpdate">
					<input type="hidden" name="command" value="prUpdate">
					<input type="hidden" name="pnum" id="pnum" value="${bean.pnum}">			
				
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="writer">작성자</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="fakewriter" id="fakewriter"
						placeholder="작성자" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.id})" disabled="disabled">
					<input type="hidden" name="writer" id="writer" value="${sessionScope.loginfo.id}">
				</div>
			</div>
								
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="category">카테고리</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="category" id="category" 
					placeholder="카테고리를 입력해 주세요.(ex. ROOM, DESK)" value="${bean.category}">
						<span class="err form-control-static">${errcategory}</span>
				</div>
			</div>				
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="ptype">좌석유형</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="ptype" id="ptype" 
					placeholder="좌석유형을 입력해 주세요.(ex. oneday, onemonth)" value="${bean.ptype}">
						<span class="err form-control-static">${errptype}</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="item">상품명</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="item" id="item" 
					placeholder="상품명을 입력해 주세요.(ex. 다인실, 1인석)" value="${bean.item}">
						<span class="err form-control-static">${erritem}</span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="seatnum">좌석이름</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="seatnum" id="seatnum" 
					placeholder="좌석번호를 입력해 주세요.(ex. A01, R01)" value="${bean.seatnum}">
						<span class="err form-control-static">${errseatnum}</span>
				</div>
			</div>	
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="hours">시간</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="hours" id="hours" 
					placeholder="이용 시간을 입력해 주세요.(ex. 1, 2, 3)" value="${bean.hours}">
						<span class="err form-control-static">${errhours}</span>
				</div>
			</div>			

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="price">가격</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="price" id="price" 
					placeholder="가격을 입력해 주세요.(ex. 1500, 3000, ... 7000, 14000)" value="${bean.price}">
						<span class="err form-control-static">${errprice}</span>
				</div>
			</div>	
			
			<div class="form-group">
				<c:if test="${applicationScope.debugMode == true }">
					이전 이미지 이름 : <br>
					${bean.pic} 
				</c:if>
				<input name="pic" type="text" value="${bean.pic}">
				
				<label class="control-label col-sm-<%=formleft%>" for="pic">상품사진</label>
				<div class="col-sm-<%=formright%>">
					<input type="file" class="form-control" name="pic"
						id="pic" placeholder="상품사진을 첨부해 주세요.">
					<span class="err">${errpic}</span>								
				</div>
			</div>
				<div class="form-group">
				<div align="center" class="col-sm-offset-3 col-sm-6">
					<button class="btn btn-default" type="submit">수정하기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-default" onclick="history.back();">
						취소</button>	
				</div>
			</div>				
			</form>													
		</div>
		</div>
	
	</div>
</body>
</html>