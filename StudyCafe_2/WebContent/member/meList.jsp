<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 목록</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<link type="text/css" href="${contextPath}/css/meList.css" rel="stylesheet" />
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	
		function selectCheck() {
			var selectCheck = $('option:selected').val();
			//alert(selectCheck);
			if (selectCheck == '-') {
				alert('정렬기준을 선택하세요.');
				return false;
			}
		}
	</script>
</head>
<body>
	<div class="container">
		<h2>회원 목록</h2>
		<form action="<%=YesForm%>" method="post">
			<input type="hidden" name="command" value="meSort">
			<ul>
				<li><select name="sort">
						<option value="-">-- 정렬 기준 --</option>
						<option value="id">아이디</option>
						<option value="name">회원이름</option>
						<option value="birth">생년월일</option>
						<option value="gender">성별</option>
						<option value="phone">휴대폰번호</option>
						<option value="email01">이메일주소</option>
						<option value="visit">방문목적</option>
						<option value="agreement">개인정보동의</option>
						
				</select></li>
				<li>
					<button type="submit" value="asc" name="asc" data-toggle="tooltip"
						data-placement="top" title="오름차순" onclick="return selectCheck();">
						<i class="fas fa-sort-amount-up-alt"></i>
					</button>
				</li>
				<li>
					<button type="submit" value="desc" name="desc"
						data-toggle="tooltip" data-placement="top" title="내림차순"
						onclick="return selectCheck();">
						<i class="fas fa-sort-amount-down-alt"></i>
					</button>
				</li>
			</ul>
		</form>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>회원 이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>휴대폰 번호</th>
					<th>이메일 주소</th>
					<th>방문목적</th>
					<th>개인정보동의</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.lists}" var="bean">
					<tr>
						<td>${bean.id}</td>
						<td>${bean.name}</td>
						<td>${bean.birth}</td>
						<td>${bean.gender}</td>
						<td>${bean.phone}</td>
						<td>${bean.email01}@${bean.email02}</td>
						<td>${bean.visit}</td>
						<td>${bean.agreement}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page" align="center">${requestScope.pagingHtml}</div>
</body>
</html>