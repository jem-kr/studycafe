<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 90%;
	}
	.thead{
		text-align:center;
	}
	.tcontent{
		min-height: 100px;
		border-bottom: 1px solid grey;
	}
	.panel{
	}
	.notice h2{
		padding-top:100px;
		font-size: 32px;
        color: #111111;
        border-bottom: 2px solid #111111;
        text-align: center;
        line-height: 100%;
        padding-bottom: 20px;
	}
	.notice h6{
		padding-bottom: 20px;
	}
</style>
</head>
<%
	int myoffset = 2; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> notice">
		<h2 align="center" class="headline">공지사항</h2>
		<h6 align="center" class="headline">그...스터디 카페의 정보와 소식을 확인하세요.</h6>
		<div class="panel panel-default ">
			<div class="panel-body">
				<div >
					<table class="table table-striped">
					<thead class="thead">
						<tr>
							<th width=20%>제목</th>
							<th width=80%> ${bean.title }</th>
						</tr>
					</thead>
					
						<tr>
							<td colspan="2" class="tcontent">						
								${bean.content }</td>
						</tr>
					
					</table>
				</div>
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
					<table>
						<tr>
							<td>
								<c:if test="${not empty bean.image}">
									<img src="${applicationScope.uploadedPath}/${bean.image}"
										class="img-thumbnail" width="200" height="200"
										alt="${bean.image}">
								</c:if>
								<c:if test="${empty bean.image}">
									<span></span>
								</c:if>
								<c:if test="${bean.image}='image'">
									<span></span>
								</c:if>
							</td>
						</tr>
					</table>
				</div>
				
				<hr>
				<div class="col-sm-offset-5 col-sm-4">
					<button class="btn btn-primary" onclick="history.back();">
						돌아 가기</button>
				</div>
			</div>
			<!-- end panel-body -->
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>