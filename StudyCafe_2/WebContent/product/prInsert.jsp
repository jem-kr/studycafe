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
<meta charset="UTF-8">
<title>상품 등록</title>
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
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="article_title">
			<h3>상품 등록</h3>
			<p>관리자 상품 등록 페이지입니다.</p>
		</div>
	<div class="panel panel-default">

		<div class="panel-body">
		
			<form class="form-horizontal" role="form" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
				<input type="hidden" name="command" value="prInsert">
						
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_type">좌석 유형</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="p_type" id="p_type" 
					placeholder="상품명을 입력해 주세요.(ex. 다인실, 1인석)" value="${bean.p_type}">
						<span class="err form-control-static">${errp_type}</span>
				</div>
			</div>
								
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_seat">좌석 번호</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" class="form-control" name="p_seat" id="p_seat" 
					placeholder="좌석 번호를 입력해 주세요.(ex. A01, R01)" value="${bean.p_seat}">
						<span class="err form-control-static">${errp_seat}</span>
				</div>
			</div>	

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_price">시작 시간</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="p_stime" id="p_stime" 
					placeholder="시작 시간을 입력해 주세요." value="${bean.p_stime}">
						<span class="err form-control-static">${errp_stime}</span>
				</div>
			</div>	
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_hour">이용 시간</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="p_hour" id="p_hour" 
					placeholder="이용 시간을 입력해 주세요." value="${bean.p_hour}">
						<span class="err form-control-static">${errpp_hour}</span>
				</div>
			</div>							
						
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_price">가격</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="p_price" id="p_price" 
					placeholder="가격을 입력해 주세요.(ex. 1500, 3000)" value="${bean.p_price}">
						<span class="err form-control-static">${errp_price}</span>
				</div>
			</div>	

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_pic">좌석 사진</label>
				<div class="col-sm-<%=formright%>">
					<input type="file" class="form-control" name="p_pic" id="p_pic" 
					placeholder="좌석 사진을 첨부해 주세요." value="${bean.p_pic}">
						<span class="err form-control-static">${errp_pic}</span>
				</div>
			</div>
			<div class="form-group">
				<div align="center" class="col-sm-offset-3 col-sm-6">
					<button class="btn btn-default" type="submit">등록하기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-default" type="reset">취소</button>
				</div>
			</div>	
			</form>													
		</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>	
</body>
</html>