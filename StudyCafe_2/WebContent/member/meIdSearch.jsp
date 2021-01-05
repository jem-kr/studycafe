<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
     <link type="text/css" href="${contextPath}/css/meIdSearch.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
    <form name="id_search" class="id_search" method="POST" action="<%=YesForm%>">
        <input type="hidden" name="command" value="meIdSearch"> 
        <h2>ID 찾기</h2>
        <ul>
            <li>
                <input type="text" id="name" name="name" value="${requestScope.name}" placeholder="이름">
                <span>${requestScope.errname}</span>
            </li>
            <li>
                <input type="text" id="phone" name="phone" value="${requestScope.phone}" placeholder="휴대폰 번호 ( - 하이픈 없이 입력하세요.)">
                <span>${requestScope.errphone}</span>
            </li>
            <li>
            	<!-- Button to Open the Modal -->
            	<c:if test="${empty requestScope.id_find}">
	         		  <span>${requestScope.id_findmsg}</span>
            	</c:if>
                <button type="submit">
                	ID 찾기
                </button>
            </li>
            <c:if test="${not empty requestScope.id_find}">
            <h3>아래의 정보를 확인하세요.</h3>
	           
	            <li class="one1"><b>${requestScope.id_findmsg}</b></li>
	            <li class="one">
	            	<i class="fas fa-angle-double-right">&nbsp;&nbsp;${requestScope.id_find}</i>
	            </li>
	            <br>
	            <li class="one"><b>로그인을 희망하시는 경우, 아래 링크를 클릭해주세요.</b></li>
	            <li><a href="<%=NoForm%>meLogin">로그인</a></li>
	            <li class="one"><b>비밀번호 찾기를 희망하시는 경우, 아래 링크를 클릭해주세요.</b></li>
	            <li><a href="<%=NoForm%>mePwSearch">비밀번호 찾기</a></li>
            </c:if>
        </ul>
    </form>
</body>
</html>