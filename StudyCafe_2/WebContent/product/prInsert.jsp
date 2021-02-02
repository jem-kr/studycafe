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
	
	
	var idCheck = 0;
	//아이디 체크하여 가입버튼 비활성화, 중복확인.
    function checkP_seat() {
        var inputed = $('.p_seat').val();
        $.ajax({
            data : {
                id : inputed
            },
            url : "checkId.jy",
            success : function(data) {
                if(inputed=="" && data=='0') {
                    $(".subbtn").prop("disabled", true);
                    $(".subbtn").css("background-color", "#aaaaaa");
                    $("#checkaa").css("background-color", "#FFCECE");
                    idCheck = 0;
                } else if (data == '0') {
                    $("#checkaa").css("background-color", "#B0F6AC");
                    idCheck = 1;
                    if(idCheck==1 && pwdCheck == 1) {
                        $(".subbtn").prop("disabled", false);
                        $(".subbtn").css("background-color", "#4CAF50");
                        signupCheck();
                    } 
                } else if (data == '1') {
                    $(".subbtn").prop("disabled", true);
                    $(".subbtn").css("background-color", "#aaaaaa");
                    $("#checkaa").css("background-color", "#FFCECE");
                    idCheck = 0;
                } 
            }
        });
    }
	
	
</script> 	
  	
<style type="text/css">
	.form-group{ 
	margin-bottom : 3px; 
	}

	.panel-heading {
	text-align: center;
	}
	
	.article_title{
	font-family: "Raleway", Sans-serif;
	}
	.article_title h2{
	font-size:32px;
	font-weight:400;
	text-align:center;
	padding-top:100px;
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
			<h2>좌석 등록</h2>
			<p>관리자 좌석 등록 페이지입니다.</p>
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
					oninput="checkP_seat()" placeholder="좌석 번호를 입력해 주세요.(ex. A01, R01)" value="${bean.p_seat}">
						<span class="err form-control-static">${errp_seat}</span>
				</div>
			</div>	

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_price">가격</label>
				<div class="col-sm-<%=formright%>">
					<input type="number" class="form-control" name="p_price" id="p_price" 
					placeholder="가격을 입력해 주세요.(ex. 1500, 6000)" value="${bean.p_price}">
						<span class="err form-control-static">${errp_price}</span>
				</div>
			</div>	
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_date">날짜</label>
				<div class="col-sm-<%=formright%>">
				<input type="text" class="form-control" name="fakep_date" id="fakep_date"
								placeholder="날짜를 선택해 주세요." value="${bean.p_date}" disabled="disabled">
					<input type="hidden" id="testDatepicker" class="form-control" name="p_date" 
					placeholder="날짜를 선택해 주세요." value="${bean.p_date}">
						<span class="err form-control-static">${errp_date}</span>
				</div>
			</div>				

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_stime">시작 시간</label>
				<div class="col-sm-<%=formright%>">
				<input type="text" class="form-control" name="fakep_stime" id="fakep_stime"
								placeholder="시작 시간을 입력해 주세요." value="${bean.p_stime}" disabled="disabled">
					<input type="hidden" class="form-control" name="p_stime" id="p_stime" 
					placeholder="시작 시간을 입력해 주세요." value="${bean.p_stime}">
						<span class="err form-control-static">${errp_stime}</span>
				</div>
			</div>	

			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_etime">종료 시간</label>
				<div class="col-sm-<%=formright%>">
				<input type="text" class="form-control" name="fakep_etime" id="fakep_etime"
								placeholder="종료 시간을 입력해 주세요." value="${bean.p_etime}" disabled="disabled">
					<input type="hidden" class="form-control" name="p_etime" id="p_etime" 
					placeholder="종료 시간을 입력해 주세요." value="${bean.p_etime}">
						<span class="err form-control-static">${errp_etime}</span>
				</div>
			</div>	
			
			<div class="form-group">
				<label class="control-label col-sm-<%=formleft%>" for="p_hour">이용 시간</label>
				<div class="col-sm-<%=formright%>">
				<input type="text" class="form-control" name="fakep_hour" id="fakep_hour"
								placeholder="이용 시간을 입력해 주세요." value="${bean.p_hour}" disabled="disabled">
					<input type="hidden" class="form-control" name="p_hour" id="p_hour" 
					placeholder="이용 시간을 입력해 주세요." value="${bean.p_hour}">
						<span class="err form-control-static">${errp_hour}</span>
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
					<br>
					<button class="subbtn btn-warning" type="submit">등록하기</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-warning" type="reset">초기화</button>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="<%=NoForm %>prList" class="btn btn-primary">목록으로</a>
					<br>
				</div>
			</div>	
			</form>													
		</div>
		</div>
	</div>
	
</body>
</html>