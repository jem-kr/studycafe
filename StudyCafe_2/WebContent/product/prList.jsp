<%@page import="mypkg.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./../common/common.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<link type="text/css" href="${contextPath }/css/productlist.css" rel="stylesheet" />

	<script type="text/javascript">
	
	
	$(document).ready(function({
	});
	function writeForm(){
		location.href='<%=NoForm%>prInsert';
	}
	function search(){
		if( $('#mode').val() == 'all' ){
			alert('검색 목록을 선택해주세요') ;				
		}
	}
	function searchAll(){
		location.href='<%=NoForm%>prList';
	}
	</script>

</head>
<body>
	<div id="sub">
		<div class="article_title">
			<h3>상품 목록</h3>
			<p>상품 목록 조회 페이지입니다.</p>
		</div>
		
		<!-- 이미지 파일, 상품등록시 파라미터로 변경하기 -->
		<div class="sels_room1">		
			<div class="sels_info">
				<ul>
					<li>${bean.pnum}</li>
				</ul>
				<ul>
					<li>${bean.item}</li>
				</ul>
				<ul class="scd">
					<li>${bean.ptype}</li>
				</ul>
				
				<!-- 상세보기 경로 수정 -->
				<ul class="sbtn">
					<a href="<%=NoForm%>prDetailFee" target="_self"><li class="r_btn1">상세보기</li></a>
					<a href="<%=NoForm%>prFee" target="_self"><li class="r_btn2">이용안내</li></a>			
					
					<c:if test="${whologin == 2}">
					<a href="<%=NoForm%>prDeleteprDelete&num=${bean.num}&${requestScope.parameters}" 
					target="_self"><li class="r_btn3">삭제</li></a>
					</c:if>
					<c:if test="${whologin != 2}">삭제</c:if>	
					
					<c:if test="${whologin == 2}">
					<a href="<%=NoForm%>prUpdate&num=${bean.num}&${requestScope.parameters}" 
					target="_self"><li class="r_btn4">수정</li></a>
					</c:if>
					<c:if test="${whologin != 2}">수정</c:if>	
				</ul>
			</div>
			
	
		</div>
		
		<div class="sels_room2">		
			<div class="sels_info">
				<ul>
					<li>${bean.pnum}</li>
				</ul>
				<ul>
					<li>${bean.item}</li>
				</ul>
				<ul class="scd">
					<li>${bean.ptype}</li>
				</ul>
				&nbsp;
				<!-- 상세보기 경로 수정 -->
				<ul class="sbtn">
					<a href="<%=NoForm%>prDetailFee" target="_self"><li class="r_btn1">상세보기</li></a>
					<a href="<%=NoForm%>prFee" target="_self"><li class="r_btn2">이용안내</li></a>					
					
					<c:if test="${whologin == 2}">
					<a href="<%=NoForm%>prDeleteprDelete&num=${bean.num}&${requestScope.parameters}" 
					target="_self"><li class="r_btn3">삭제</li></a>
					</c:if>
					<c:if test="${whologin != 2}">삭제</c:if>	
					
					<c:if test="${whologin == 2}">
					<a href="<%=NoForm%>prUpdate&num=${bean.num}&${requestScope.parameters}" 
					target="_self"><li class="r_btn4">수정</li></a>
					</c:if>
					<c:if test="${whologin != 2}">수정</c:if>	
				
				</ul>
			</div>
		</div>
	</div>
				<table class="table">
				<tr>
					<td style="border-top: none;" colspan="12" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=YesForm%>" method="get">
							<input type="hidden" name="command" value="prList">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="all" selected="selected">------선택하세요-----
									<option value="item">상품명
									<option value="category">카테고리									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
							
							<c:if test="${whologin == 2}">
								<button class="btn btn-default btn-info" type="button"
									onclick="writeForm();">상품 등록</button>
							</c:if>
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
			</tr>	
	</table>	

</body>
</html>