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
	
	//DatePicker 날짜 선택
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

	//TimePicker 시간 선택
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
	
	//TimePicker 시간 선택 / etime 시간 기본 설정
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
	       });
	});
	
 
		//calculate() : 
		//이용 시간 계산 함수, fakep_hour로 수정함 
		function calculate() {
		var p_stime = $('#p_stime').val();
		var p_etime = $('#p_etime').val();
		
		if (p_etime != 0) {
			var fakep_hour = p_etime - p_stime;
			$('input#fakep_hour').val(fakep_hour);	
			$('input#p_hour').val(fakep_hour);
		} else {
			return false;
		}
	}
	
	function totalcal() {
		var p_hour = $('#p_hour').val();
		var p_price = $('#p_price').val();

		
		if(p_hour !=0){
	 	var p_price = $('#p_price').val() * p_hour;
		$('input#fakep_price').val(p_price);
		$('input#p_price').val(p_price);
	 		return true;
		}
	}

	
	function check_seatnum() {
	      // 수정할 좌석 번호 입력
	      if(confirm("수정하시겠습니까?")==true){
	           var _p_seat = prompt("수정할 좌석 번호를 입력하세요."); 
	           var p_seat = _p_seat.toUpperCase(); // 문자가 들어오면 무조건 대문자로 바꿔줌 
	           //alert(p_seat);
	          if ( p_seat.length == 3) { // 3 글자 수 일때만
	             if (p_seat.charAt(0) == 'R' || p_seat.charAt(0) == 'A' ) { // 좌석번호가 A,R로 시작
	                location.href='<%=NoForm%>prUpdate&p_seat=' + p_seat;
	                return true;
	             }else{
	                alert("올바르지 않은 좌석 번호입니다.");
	                 return false;   
	             }
	         }else{
	            alert("올바르지 않은 좌석 번호입니다.");
	             return false;   
	           }
	        }else{
	          return false;
	        }
	   }
	
	function del() {
	      // 삭제할 좌석 번호 입력
	      if(confirm("삭제하시겠습니까?")==true){
	           var _p_seat = prompt("삭제할 좌석 번호를 입력하세요."); 
	           var p_seat = _p_seat.toUpperCase(); // 문자가 들어오면 무조건 대문자로 바꿔줌 
	           //alert(p_seat);
	          if ( p_seat.length == 3) { // 3 글자 수 일때만
	             if (p_seat.charAt(0) == 'R' || p_seat.charAt(0) == 'A' ) { // 좌석번호가 A,R로 시작
	                location.href='<%=NoForm%>prDelete&p_seat=' + p_seat;
	                return true;
	             }else{
	                alert("올바르지 않은 좌석 번호입니다.");
	                 return false;   
	             }
	         }else{
	            alert("올바르지 않은 좌석 번호입니다.");
	             return false;   
	           }
	        }else{
	          return false;
	        }
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
</style>	
	
	
	<meta charset="UTF-8">
	<title>BootStrap Sample</title>


</head>
<%
	int myoffset = 1; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 7; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body>

	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="title">
			<h3 align="center">좌석 상세보기</h3>
			<p>원하시는 좌석과 날짜, 시간을 선택해주세요</p>
		</div>	
		<div class="panel">
		
			<div class="panel-body">
		
			<form class="form-horizontal" role="form" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
				<input type="hidden" name="command" value="prInsert">
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
				
					<table class="table01" style="table-layout:fixed">
								<c:if test="${empty bean.p_pic}">
									<c:if test ="${bean.p_type=='1인석' }">
									<img src="<%=uploadedFolder%>/room02.png" class="img-thumbnail"
										width="700" height="600" alt="no image">
									</c:if>
									<c:if test ="${bean.p_type=='다인실' }">
									<img src="<%=uploadedFolder%>/room03.png" class="img-thumbnail"
										width="700" height="600" alt="no image">
									</c:if>
								</c:if>						
								
								
								<c:if test="${not empty bean.p_pic}">
									<img src="${contextPath}/upload/${bean.p_pic}"
										class="img-thumbnail" width="700" height="600"
										alt="${bean.p_pic}">
								</c:if>		
					</table>
				</div>
			</form>
				
				<form name="form" method="post" action="<%=YesForm%>">
				<input type="hidden" value="reInsert" name="command">
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>" >
					<table class="table02 table-condensed " style="table-layout:fixed">				
						
						<tr>
							<td width="40%" align="center">좌석 유형</td>
							<td width="60%" align="left">
						<input type="text" class="form-control" name="fakep_type" id="fakep_type"
								placeholder="좌석 유형" value="${bean.p_type}" disabled="disabled">
							<input type="hidden" name="p_type" id="p_type"
								value="${bean.p_type}">	
						</td>

						<tr>
							<td width="40%" align="center">좌석 번호</td>
							<td width="60%" align="left">
							<select class="form-control" name="p_seat" id="p_seat">
							
							<option value="-">
							------선택하세요------
							
							<c:forEach var="glists" items="${requestScope.glists}">
							<option value="${glists.p_seat}">${glists.p_seat}</option>
							</c:forEach>
							</select>
								<span class="err form-control-static">${errp_seat}</span>
							</td>
						</tr>
						
						
						<tr>
						<c:if test="${bean.p_type == '1인석' }">
							<input type="hidden" name="p_person" value="1"/>
							</c:if>
						<c:if test="${bean.p_type == '다인실'}">
							<td width="40%" align="center">인원</td>
							<td width="60%" align="left">
							<select class="form-control" name="p_person">
							<option value="0" selected="selected">
							------선택하세요------
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							</select>
							
							<span class="err form-control-static">${errp_person}</span>
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
								<input type="number" id="p_stime" name = "p_stime" 
								placeholder="시작 시간" class="form-control timeset" value="${bean.p_stime}">
								<span class="err form-control-static">${errp_stime}</span>
							</td>
						</tr>						
						
						<tr>
							<td width="40%" align="center">종료 시간</td>
							<td width="60%" align="left">
								<input type="number" id="p_etime" name = "p_etime" 
								placeholder="종료 시간" class="form-control" value="${bean.p_etime}"
								onmouseout="calculate();">
								<span class="err form-control-static">${errp_etime}</span>
							</td>
						</tr>	
							

						<!-- 이용 시간 계산 함수, fakep_hour로 수정함 -->						
						<tr>
							<td width="40%" align="center">이용 시간</td>
							<td width="60%" align="left">
								<input type="hidden" id="p_hour" name="p_hour"  >					
								<input type="number" id="fakep_hour" name="fakep_hour"  
								placeholder="이용 시간" class="form-control" disabled="disabled">
								<span class="err form-control-static">${errp_hour}</span>
							</td>
						
						<!-- 총 가격 연산 -->
						<tr>
							<td colspan="2" align="center" style="padding-top:30px">
							<a href="<%=NoForm%>prList&" class="btn btn-warning" role="button">목록보기</a>
							<c:if test="${whologin ==1 }">
							&nbsp;&nbsp;
							<button type="submit" class="btn btn-primary">예약하기</button>
							</c:if>
							<hr>
							<c:if test="${whologin ==0 }">
							<span style="font-size: 12pt;"> 예약하시려면 <span style="color:red;">로그인</span> 해주세요.</span><br>
							</c:if>
							</td>
						<tr>
					</table>
				
				</div>
				</form>
				<span style="font-size: 12pt;">
				1인석은 1시간에 1500원, 다인실은 1시간에 6000원 입니다. 
				</span>
			</div>
			
			<!-- end panel-body -->
			<hr>
			<div class="col-sm-offset-5 col-sm-4">

			<c:if test="${whologin == 2 }">
               
            <button onclick="return check_seatnum();" class="btn btn-warning" role="button">상품수정</button>
            &nbsp;&nbsp;
            <button onclick="return del();" class="btn btn-danger" role="button">상품삭제</button>
            <br><br><br>
      	   </c:if>   
			</div>
		
		</div>
		
	</div>
	
</body>
</html>
