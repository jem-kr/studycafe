<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>BootStrap Sample</title>

<script type="text/javascript">
var sell_price;
var amount;

function init () {
	sell_price = document.form.sell_price.value;
	amount = document.form.amount.value;
	document.form.sum.value = sell_price;
	change();
}

function add () {
	hm = document.form.amount;
	sum = document.form.sum;
	hm.value ++ ;

	sum.value = parseInt(hm.value) * sell_price;
}

function del () {
	hm = document.form.amount;
	sum = document.form.sum;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function change () {
	hm = document.form.amount;
	sum = document.form.sum;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}  

</script>
<style type="text/css">

	.panel, table01, table02{
	table-layout:fixed;	
	}
	
	.panel,img-thumbnail {
    webkit-box-shadow: none;
    box-shadow: none;
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
	.table01, table02, tr,td,th{
	border-collapse: collapse;
	}
	.btn{
	align:center;
	}
	
	.table01{
	border-top-style: none;
    border-left-style: none;
    border-right-style: none;
    border-bottom-style: none;
	}
	
	.table02{
/*	border-top-style: none;
    border-left-style: none;
    border-right-style: none;
    border-bottom-style: none;*/
	}

	
</style>
</head>
<%
	int myoffset = 1; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 7; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body onload="init();">
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="title">
			<h3 align="center">상품 상세보기</h3>
			<p>상품 상세보기 페이지입니다.</p>
		</div>	
		<div class="panel">
			<div class="panel-body">
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
					<table class="table01" style="table-layout:fixed">
						<tr>
							<td>
								<c:if test="${empty bean.pic}">
									<img src="<%=uploadedFolder%>room02.png" class="img-thumbnail"
										width="600" height="600" alt="no image">
								</c:if>						
								
								<c:if test="${applicationScope.debugMode == true}">
									디버그 모드가 true이면 보입니다.<br>
									${applicationScope.uploadedPath}/${bean.pic}
								</c:if>
								
								<c:if test="${not empty bean.pic}">
									<img src="${applicationScope.uploadedPath}/${bean.pic}"
										class="img-thumbnail" width="600" height="600"
										alt="${bean.pic}">
								</c:if>
							</td>
						</tr>
					</table>
				</div>
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>">
					<table class="table02 table-condensed ">
						<tr class="table-light">
							<td width="40%" align="center">좌석유형</td>
							<td width="60%" align="left">${bean.ptype}</td>
						</tr>
				
						<tr>
							<td width="40%" align="center">상품명(번호)</td>
							<td width="60%" align="left">${bean.item}(${bean.pnum})</td>
						</tr>
						<tr>
							<td width="40%" align="center">카테고리</td>
							<td width="60%" align="left">${bean.category}</td>
						</tr>						
						<tr>
							<td width="40%" align="center">좌석번호</td>
							<td width="60%" align="left">${bean.seatnum}</td>
						</tr>
						
						
						<form name="form" method="get">
						<tr>
							<td width="40%" align="center">시간</td>
							<td width="60%" align="left">
							<input type=hidden name="sell_price" value="1500">
							<input type="text" name="amount" value="1" size="3" onchange="change();">
							<input type="button" value=" + " onclick="add();">
							<input type="button" value=" - " onclick="del();">
						</tr>
						<tr>
							<td width="40%" align="center">가격</td>
							<td width="60%" align="left">				
							<input type="text" name="sum" size="11" readonly>원
							<button type="submit" class="btn btn-xs btn-default">예약담기</button>
							
							</td>
						</tr>
						</form>										
				</table>
				</div>
			</div>
			<!-- end panel-body -->
					<div class="col-sm-offset-5 col-sm-4">
					<button class="btn btn-default" onclick="history.back();">
						뒤로가기</button>
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