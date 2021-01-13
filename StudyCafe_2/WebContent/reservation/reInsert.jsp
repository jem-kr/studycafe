<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="./../common/common.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2*myoffset;
	int formleft = 2 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

	.reservation h2{
		padding-top:100px;
		font-size: 32px;
        color: #111111;
        border-bottom: 2px solid #111111;
        text-align: center;
        line-height: 100%;
        padding-bottom: 20px;
	}
	.reservation h4{
	}
	.reservation h6{
		color: red;
	}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> reservation">
			<h2 align="center"> 예약상품을 확인해주세요</h2>
		<div class="panel panel-default"> 
					<div>
						<h4 align="center">${sessionScope.loginfo.name }님의 예약내역입니다.</h4>
						<h6 align="center">선택하신 날짜, 시간, 좌석, 인원을 확인해주세요.</h6>
					</div>
			<table class="table table-dark table-hover ">
				
					
				<thead>
				<tr>
					<td colspan="8" align="right">
					<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="post">
					<input type="hidden" name="command" value="orList">
					</form>
					</td>	
				</tr>
				
				<tr class="tablehd">
					<th width="10%">예약자</th>
					<th width="10%">좌석타입</th>
					<th width="10%">선택좌석</th>
					<th width="10%">선택일자</th>
					<th width="10%">시작시간</th>
					<th width="10%">종료시간</th>
					<th width="10%">총 이용시간</th>
					<th width="10%">이용 인원</th>
					<th width="10%">금액</th>
				</tr>
				</thead>
				
					<tr>
						<td>${bean.re_id }</td>
						<td>${bean.re_type }</td>
						<td>${bean.re_seat }</td>
						<td>${bean.re_date }</td>
						<td>${bean.re_stime }시</td>
						<td>${bean.re_etime }시</td>
						<td>${bean.re_hour }시간</td>
						<td>${bean.re_person }명</td>
						<td>${bean.re_price }원</td>
					</tr>
					
			</table>
			
		</div>
		<div class="row">
				<div class="col-sm-12 text-right" >
					<button  type="submit" class="btn btn-primary" >
						결제하기</button>  
					<!-- <a href="" class="btn btn-primary" role="button" onclick="">결제하기</a>	 -->
						&nbsp;&nbsp;
					<a href="<%=NoForm %>prDetail&p_seat=${bean.p_seat}" class="btn btn-primary" role="button">취소하기</a>		
				</div>
				</div>
	</div>
</body>
</html>