<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
<%@page import="java.io.File"%>

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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-warning">
			<div class="panel-heading">
				<h4>공지사항 수정하기</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=YesForm%>"  method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="noUpdate">
					<input type="hidden" name="num" id="num" value="${bean.num }">
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
						<c:if test="${applicationScope.debugMode==true }">
							이전 이미지 이름 : <br>
							${bean.image }
						</c:if>
						<!--이전 이미지에 대한 정보를 히든 파라미터로 넘깁니다.  -->
						<!--자바의 File 클래스를 이용해 삭제해야 합니다.   -->
						<input name ="image" type="text" value="${bean.image }">
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
							<input type="datetime" class="form-control" name="regdate"
								id="regdate" placeholder="작성 일자" value="${bean.regdate}"> <span
								class="err">${errregdate}</span>
						</div>
					</div>
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">수정완료</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>