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
<title>BootStrap Sample</title>
	<style type="text/css">
		.form-group{ margin-bottom : 3px; }
	</style>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading"><h4>상품 등록</h4></div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=YesForm%>" 
					method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="prInsert"> 
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="name">상품명</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="name" id="name"								
								placeholder="상품명" value="${bean.name}">
								<span class="err form-control-static">${errname}</span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="company">제조 회사</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="company" id="company"								
								placeholder="제조 회사" value="${bean.company}">
							<span class="err form-control-static">${errcompany}</span>								
						</div>
					</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="image">이미지</label>
						<div class="col-sm-<%=formright%>">
							<input type="file" class="form-control" name="image"
								id="image" placeholder="이미지를 넣어 주셔용^^">
							<span class="err form-control-static">${errimage}</span>								
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="stock">재고</label>
						<div class="col-sm-<%=formright%>">
							<input type="number" class="form-control" name="stock"
								id="stock" placeholder="재고 수량을 넣어 주셔용^^" value="${bean.stock}">
							<span class="err form-control-static">${errstock}</span>								
						</div>
					</div>	
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="price">단가</label>
						<div class="col-sm-<%=formright%>">
							<input type="number" class="form-control" name="price"
								id="price" placeholder="단가 를 넣어 주셔용^^" value="${bean.price}">
							<span class="err form-control-static">${errprice}</span>
						</div>
					</div>
					<div class="form-group">
						<label for="category" class="col-xs-<%=formleft%> col-lg-<%=formleft%> control-label">카테고리</label>
	        			<div class="col-xs-<%=formright%> col-lg-<%=formright%>">
							<select class="form-control" name="category" id="category">
								<option value="-" selected="selected">-- 선택하세요
									---------
								<c:if test="${bean.category == 'NORMAL'}">
		        					<option value="NORMAL" selected="selected">NORMAL
		        				</c:if>        			
		            			<c:if test="${bean.category != 'NORMAL'}">
		        					<option value="NORMAL">NORMAL
		        				</c:if>										
								<c:if test="${bean.category == 'HIT'}">
		        					<option value="HIT" selected="selected">인기 상품
		        				</c:if>        			
		            			<c:if test="${bean.category != 'HIT'}">
		        					<option value="HIT">인기 상품
		        				</c:if>	 
								<c:if test="${bean.category == 'NEW'}">
		        					<option value="NEW" selected="selected">신상품
		        				</c:if>        			
		            			<c:if test="${bean.category != 'NEW'}">
		        					<option value="NEW">신상품
		        				</c:if>	
								<c:if test="${bean.category == 'BEST'}">
		        					<option value="BEST" selected="selected">베스트 상품
		        				</c:if>        			
		            			<c:if test="${bean.category != 'BEST'}">
		        					<option value="BEST">베스트 상품
		        				</c:if>
							</select>
							<span class="err form-control-static">${errcategory}</span>
 	        			</div>
	        		</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="contents">상품 설명</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="contents" id="contents" rows="5" cols="" 
								placeholder="상품 설명" class="form-control">${bean.contents}</textarea>
							<span class="err form-control-static">${errcontents}</span>								
						</div>
					</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="point">포인트</label>
						<div class="col-sm-<%=formright%>">
							<input type="number" class="form-control" name="point"
								id="point" placeholder="포인트 수량을 넣어 주셔용^^" value="${bean.point}">
							<span class="err form-control-static">${errpoint}</span>								
						</div>
					</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="inputdate">입고 일자</label>
						<div class="col-sm-<%=formright%>">
							<input type="datetime" class="form-control" name="inputdate" id="inputdate"								
								placeholder="입고 일자" value="${bean.inputdate}">
								<span class="err form-control-static">${errinputdate}</span>
						</div>
					</div>					
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">상품 등록</button>
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