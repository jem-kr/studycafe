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
 	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
	<script type="text/javascript">
	$(function() {
    $( "#testDatepicker" ).datepicker({
       dateFormat:  "yy/mm/dd", 
       changeMonth: true,
       dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
       minDate: 0, 
        maxDate: "+2w"     
    	});
	});
</script>  	
  	
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
				<label class="control-label col-sm-<%=formleft%>" for="p_date">날짜</label>
				<div class="col-sm-<%=formright%>">
					<input type="text" id="testDatepicker" class="form-control" name="p_date" 
					placeholder="날짜" value="${bean.p_date}">
						<span class="err form-control-static">${errp_date}</span>
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
				<label class="control-label col-sm-<%=formleft%>" for="p_etime">종료 시간</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="p_etime" id="p_etime" 
					placeholder="종료 시간을 입력해 주세요." value="${bean.p_etime}">
						<span class="err form-control-static">${errp_etime}</span>
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
				<c:if test="${applicationScope.debugMode == true }">
					이전 이미지 이름 : <br> ${bean.p_pic} 
				</c:if>
				<input name="p_pic" type="text" value="${bean.p_pic}">
				
				<label class="control-label col-sm-<%=formleft%>" for="pic">좌석 사진</label>
				<div class="col-sm-<%=formright%>">
					<input type="file" class="form-control" name="p_pic"
						id="p_pic" placeholder="좌석 사진을 첨부해 주세요.">
					<span class="err">${errp_pic}</span>								
				</div>
			</div>
			
			<div class="form-group">
				<div align="center" class="col-sm-offset-3 col-sm-6">
					<button class="btn btn-default" type="submit">수정하기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					<button class="btn btn-default" type="reset" onclick="history.back()">뒤로가기</button>
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