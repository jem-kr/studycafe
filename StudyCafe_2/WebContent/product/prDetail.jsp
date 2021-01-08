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
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
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
	
	$(function() { 
	    $("#p_stime").timepicker({
	        timeFormat: 'HH',
	        interval: 60,
	        minTime: '09',
	        maxTime: '20',
	        startTime: '09',
	        dynamic: false,
	        dropdown: true,
	        scrollbar: true        
	    });
	});
	$(function() { 
	       $('#p_etime').timepicker({
	    	   	timeFormat: 'HH',
		        interval: 60,
		        minTime: '10',
		        maxTime: '21',
		        startTime: '10',
		        dynamic: false,
		        dropdown: true,
		        scrollbar: true  
	       
	       
	       });//etime 시간 기본 설정

	});
</script>
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

function del_hour () {
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

function writeForm(){
	location.href='<%=NoForm%>prInsert';
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

function del_hour () {
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

	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="title">
			<h3 align="center">상품 상세보기</h3>
			<p>상품 상세보기 페이지입니다.</p>
		</div>	
		<div class="panel">
		
			<div class="panel-body">
		
			<form class="form-horizontal" role="form" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
				<input type="hidden" name="command" value="prInsert">
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
				
					<table class="table01" style="table-layout:fixed">
								<c:if test="${empty bean.p_pic}">
									<img src="<%=uploadedFolder%>/room02.png" class="img-thumbnail"
										width="700" height="700" alt="no image">
								</c:if>						
								
								<%--<c:if test="${applicationScope.debugMode == true}">
									디버그 모드가 true이면 보입니다.<br>
									${applicationScope.uploadedPath}/${bean.p_pic}
								</c:if> --%>
								
								<c:if test="${not empty bean.p_pic}">
									<img src="${uploadedPath}/${bean.p_pic}"
										class="img-thumbnail" width="700" height="700"
										alt="${bean.p_pic}">
								</c:if>		
					</table>
				</div>
			</form>
				
				<form name="form" method="post" action=<%=YesForm%>">
				<input type="hidden" value="reInsert" name="command">
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>" >
					<table class="table02 table-condensed " style="table-layout:fixed">				
						
						<tr>
							<td width="40%" align="center">좌석 번호</td>
							<td width="60%" align="left">
							<select class="form-control" name="p_seat" id="p_seat">
							
							<option value="-" selected="selected">
							------선택하세요------
							
							<c:forEach var="glists" items="${requestScope.glists}">
							<option value="${glists.p_seat }">${glists.p_seat}</option>
							</c:forEach>
							</select>
								<span class="err form-control-static">${errp_seat}</span>
							</td>
						</tr>
						
						
						<tr>
						<c:if test="${bean.p_type == '다인실'}">
							<td width="40%" align="center">인원</td>
							<td width="60%" align="left">
							<select class="form-control">
							<option value="-" selected="selected">
							------선택하세요------
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							</select>
							</td>
						</c:if>
						</tr>
						
						<tr>
							<td width="40%" align="center">날짜</td>
							<td width="60%" align="left">
							<input type="text" id="testDatepicker" class="form-control" name="p_date" 
							placeholder="날짜" value="${bean.p_date}">
								<span class="err form-control-static">${errp_date}</span>
							</td>
						</tr>	
						
						<tr>
							<td width="40%" align="center">시작 시간</td>
							<td width="60%" align="left">
							<input type="text" id="p_stime" name = "p_stime" 
							placeholder="시작 시간" class="time" value="${bean.p_stime }">
							<%-- <select class="form-control" name="p_stime" id="p_stime">
							<option value="-" selected="selected">
							----선택하세요----
							<c:forEach var="i" begin="09" end="21" step="1">
							<option value="${i }">${i}</option>
							</c:forEach>
							</select> --%>
								<span class="err form-control-static">${errp_stime}</span>
							</td>
						</tr>						
						
						<tr>
							<td width="40%" align="center">종료 시간</td>
							<td width="60%" align="left">
							<input type="text" id="p_etime" name = "p_etime" 
							placeholder="종료 시간" class="time" value="${bean.p_etime }">
							<%--<select class="form-control" name="p_etime" id="p_etime">
							<option value="-" selected="selected"> 
							----선택하세요----
							
							<option>${bean.p_etime}</option>
							</select> --%>
								<span class="err form-control-static">${errp_etime}</span>
							</td>
						</tr>		
						
						<tr>
							<td width="40%" align="center">이용 시간</td>
							<td width="60%" align="left">
							<input type=hidden name="sell_price" value="${bean.p_price}">
							<input type="text" name="amount" value="1" size="3" onchange="change();">
							<input type="button" value=" + " onclick="add();">
							<input type="button" value=" - " onclick="del_hour();">
						</tr>
						<tr>
							<td width="40%" align="center">가격</td>
							<td width="60%" align="left">				
							<input type="text" name="sum" size="11" readonly>원
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="padding-top:30px">
							<a href="<%=NoForm%>prList&" class="btn btn-default" role="button">목록보기</a>
							<button type="submit">예약하기</button>
						<tr>
					</table>
				
				</div>
				</form>
			</div>
			
			<!-- end panel-body -->
			<div class="col-sm-offset-5 col-sm-4">

			<c:if test="${whologin==2 }">
				<a href="<%=NoForm%>prInsert&p_seat=${bean.p_seat}" onclick="writeForm();" class="btn btn-info" role="button">등록</a>				
				<a href="<%=NoForm%>prUpdate&p_seat=${bean.p_seat}" class="btn btn-info" role="button">수정</a>
				<a href="<%=NoForm%>prDelete&p_seat=${bean.p_seat}" onclick="del();" class="btn btn-info" role="button">삭제</a>
				<br><br><br>
			</c:if>									
		
			</div>
		
		</div>
		
	</div>
	<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});	
	
	function del(){
		if(confirm("정말 삭제하시겠습니까?")==true){
			list_ok.submit();
	}
	</script>
</body>
</html>
