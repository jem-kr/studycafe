<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="./../common/common.jsp"  %>
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
<meta charset="UTF-8">
<script type="text/javascript">
function delconfirm(){
	if(confirm("예약을 취소합니까?")==true){
		location.href='<%=NoForm %>prList';
		alert("예약이 취소되었습니다.")
	}else{
		return;		
	}
}
</script>
<title>Insert title here</title>
<style type="text/css">
.order h2{
	padding-top: 80px;
}
</style>
</head>
<body>
<c:if test="${not empty requestScope.bean }" >
<div class = "container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> order">
			<h2 align="center"> ${sessionScope.loginfo.name }님의 최근 완료된 예약내역입니다.</h2>
			<h6 align="center"></h6>
		<div class="panel panel-default"> 
					<div>
					</div>
			<table class="table table-dark table-hover ">
				
					
				<thead>
				<tr>
				<th colspan="8" align="center">
					${bean.or_pday }결제한 결제내역입니다. 
				</tr>
				<tr class="tablehd">
					<th width="10%">예약번호</th>
					<th width="10%">선택좌석</th>
					<th width="10%">선택일자</th>
					<th width="10%">시작시간</th>
					<th width="10%">종료시간</th>
					<th width="10%">총 이용시간</th>
					<th width="10%">금액</th>
					<th width="10%">비고</th>
				</tr>
				</thead>
				
					<tr>
						<td>${bean.or_no }</td>
						<td>${bean.or_seat }</td>
						<td>${bean.or_date }</td>
						<td>${bean.or_stime }시</td>
						<td>${bean.or_etime }시</td>
						<td>${bean.or_hour }시간</td>
						<td>${bean.or_price }원</td>
						<td>
							<a href="<%=NoForm %>orDelete&or_no=${bean.or_no}" onclick="delconfirm();">예약 취소</a>
						</td>
					</tr>
					
			</table>
			</div>
		</div>
	</c:if>
	<c:if test="${empty requestScope.bean }">
	<div class = "container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> order">
			<h2 align="center"> ${sessionScope.loginfo.name }님의 최근 완료된 예약내역입니다.</h2>
			<h6 align="center"></h6>
		<div class="panel panel-default"> 
					<div>
					</div>
			<table class="table table-dark table-hover ">
				
					
				<thead>
				<tr class="tablehd">
					<th width="10%">예약번호</th>
					<th width="10%">선택좌석</th>
					<th width="10%">선택일자</th>
					<th width="10%">시작시간</th>
					<th width="10%">종료시간</th>
					<th width="10%">총 이용시간</th>
					<th width="10%">금액</th>
					<th width="10%">비고</th>
				</tr>
				<tr>
			
				</thead>
					<tr >
						<th colspan="7" align="center"> 예약하신 내역이 없습니다. </th>
						<th><a href="<%=NoForm%>prList">예약하기</a></th>
					</tr>
					
			</table>
			</div>
		</div>
	</c:if>
</body>
</html>