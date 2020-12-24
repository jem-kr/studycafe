<%@page import="mypkg.dao.NotifyDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "./../common/common.jsp" %>
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
<style type="text/css">
	.panel{
	}
	.re{
		font-size:10px;
	}
	.tablehd th{
		text-align:center;
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
	.footer{
		text-align: center;
	}
</style>
<script type="text/javascript">
	function writeForm(){
			location.href='<%=NoForm%>noInsert';
	}
	function search(){
		if( $('#mode').val() == 'all' ){
			alert('검색 목록을 선택해주세요') ;
			//$('#mode').focus();
		}else{
		}
	}
	function searchAll(){
		//$('#mode').val('-');
		//$('#keyword').val('');
		location.href='<%=NoForm%>noList';
	}
</script>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> notice"> 
		<h2 align="center" class=>공지사항 목록</h2>
		<div class= "panel panel-default"> 
			<!-- <div class="panel-heading">
				<form class="form-inline" role="form">
					
				</form>
			</div> -->
			<table class="table table-hover table-striped">
				
				<thead>
				<tr>
					<td colspan="8" align="right">
					<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="get">
						<input type="hidden" name="command" value="noList">
						<div class="form-group">
							<select class="form-control" name="mode" id="mode">
							<option value="all" selected="selected">------
							<option value="title">제목
							<option value="content">내용
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control btn-xs" name="keyword"
								id="keyword" placeholder="검색하실 단어를 입력하세요">
						</div>
						<button class="btn btn-default btn-info" type="submit" onclick="search();">검색</button>
						<button class="btn btn-default btn-info" type="button" onclick="searchAll();">전체보기</button>
						<button class="btn btn-default btn-primary" type="button" onclick="writeForm();">작성</button>
						&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
						<p class="form-control-static">${requestScope.pagingStatus }</p>
					</form>
					</td>		
				</tr>
				<tr class="tablehd">
					<th width="5">no</th> 
					<th width="55%">제목</th>
					<th width="10%">작성자</th>
					<th width="5%">조회수</th>
					<th width="15%">작성일자</th>
					<!-- <th width="5%">수정</th>
					<th width="5%">삭제</th> -->
					<th width="5%">답글</th>
					<!-- <th width="5%">비고</th> -->
				</tr>
				</thead>
				
				<c:forEach var="bean" items="${requestScope.lists }">
					<tr>
						<td>${bean.num }</td>
						<td>
						<c:forEach var="cnt" begin="1" end="${bean.depth }">
							<span class="badge re">└></span>
						</c:forEach>
						<a href="<%=NoForm%>noDetailView&num${bean.num}&${requestScope.parameters }">
							${bean.title }
						</a>
						</td>
						<td>${bean.writer }</td>
						<td>${bean.readhit }</td>
						<td>${bean.regdate }</td>
						<%-- <td>
							<c:if test="${sessionScope.loginfo.id == bean.writer }">
								<a href="<%=NoForm%>noUpdate&num=${bean.num}&${requestScope.parameters}">
								수정
								</a>
							</c:if>
							<c:if test="${sessionScope.loginfo.id != bean.writer }">
								수정
							</c:if>
						</td>
						<td>
							<c:if test="${sessionScope.loginfo.id == bean.writer}">
								<a href="<%=NoForm%>noDelete&num=${bean.num}&${requestScope.parameters}">
									삭제
								</a>
							</c:if>
							<c:if test="${sessionScope.loginfo.id != bean.writer}">
								삭제
							</c:if>
						</td> --%>
						<td>
							<c:if test="${bean.depth <3 }">
								<a href="<%=NoForm%>noReply&num=${bean.num}&${requestScope.parameters}&groupno=${bean.groupno}&orderno=${bean.orderno}&depth=${bean.depth}">
									답글 
								</a>
							</c:if>
							<c:if test="${bean.depth >= 3 }">
								답글
							</c:if>
						</td>
						<%-- <td>
							${bean.remark }
						</td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
			<div class="footer">${requestScope.pagingHtml }</div>
		</div>
	
	
	<script type="text/javascript">
	   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val( '${requestScope.keyword}' ) ;		
	</script>
</body>
</html>