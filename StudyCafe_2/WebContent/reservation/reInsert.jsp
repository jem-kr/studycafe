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
	.reservation h6{
		color: red;
	}
	.check{
		color: red;
	}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function delconfirm(){
	if(confirm("예약을 취소합니까?")==true){
		location.href='<%=NoForm %>prList';
		alert("예약이 취소되었습니다.")
	}else{
		return;		
	}
}

function pay(){
	if(confirm("예약하신 내역은 수정이 불가합니다.\n결제하시겠습니까?")==true){
		location.href='<%=NoForm %>orList&re_id=${sessionScope.loginfo.id}';
	}else{
		return;		
	}
}

</script>
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
					<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="get">
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
					<!-- <button  type="submit" class="btn btn-primary" >
						결제하기</button --> 
<!-- 					<button class="btn btn-default btn-primary" type="button" onclick="pay();">결제하기</button>	
 -->					<a class="btn btn-primary" role="button" onclick="pay()">결제하기</a>
						&nbsp;&nbsp;
					<button class="btn btn-default btn-danger" type="button" onclick="delconfirm();">취소하기</button>		
				</div>
				</div>
				<div align="center" class="check">
				<hr>
				<h5>● 예약하신 내용은 변경이 불가하오니 한번 더 확인해주세요.</h5>
				<h5>● 만약 변경을 원하시면, 예약을 취소한 뒤 다시 예약해야합니다.</h5>
				<h5>● 예약일 하루 전에는 취소가 불가능합니다.</h5>
				
				</div>
	</div>
</body>
</html>