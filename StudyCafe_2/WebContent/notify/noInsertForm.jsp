<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
<%@page import="mypkg.dao.NotifyDao" %>
<%
	int myoffset =2;
	int mywidth = twelve-2*myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
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
        maxDate: 0
    	
    });
});
</script>
<style type="text/css">
	.panel{
		
	}
	.panel h2{
	padding-top: 100px;
		text-align: center;
		font:32px;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2>공지사항 등록</h2>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="noInsert">
<%-- 					<input type="hidden" name="num" value="${bean.num }">
 --%>				<%-- 	<input type="hidden" name="pageNumber" value="${param.pageNumber}">
					<input type="hidden" name="pageSize" value="${param.pageSize}">
					<input type="hidden" name="mode" value="${param.mode}">
					<input type="hidden" name="keyword" value="${param.keyword}"> --%>
					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="writer">작성자</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="fakewriter" id="fakewriter"
								placeholder="작성자" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.id})" disabled="disabled">
							<input type="hidden" name="writer" id="writer"
								value="${sessionScope.loginfo.id}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="title">글
							제목</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="title"
								id="title" placeholder="글 제목" value="${bean.title}"> 
							<span class="err">${errtitle}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="content">글
							내용</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="content" id="content" rows="5" cols=""
								placeholder="글 내용" class="form-control">${bean.content}</textarea>
							<span class="err">${errcontent}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="image">첨부파일</label>
						<div class="col-sm-<%=formright%>">
								<input type="file" class="form-control" name="image" id="image" placeholder="첨부할 파일이 있으면 추가해주세요.">
							<span class="err" >${errimage}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="regdate">작성
							일자</label>
						<div class="col-sm-<%=formright%>">
						<input type="text" id="testDatepicker" class="form-control" name="regdate" placeholder="작성 일자" value="${bean.regdate}">  
							 <span
								class="err">${errregdate}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="fix">중요공지</label>
						<div class="col-sm-<%=formright%>">
							 <select name="fix" id="fix">
							 	<option value="2" selected="selected">--</option>
    							<option value="1">중요</option>
							    <option value="0">일반</option>
							  </select>
							<span class="err">${errfix}</span>
						</div>
					</div>
					
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">등록하기</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">초기화</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=NoForm%>noList&${requestScope.parameters}" class="btn btn-primary" role="button">목록보기</a>	
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>