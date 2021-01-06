<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 변경</title>
     <link type="text/css" href="${contextPath}/css/mePwChange.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
    <form name="pw_change" class="pw_change" method="POST" action="<%=YesForm%>">
        <input type="hidden" name="command" value="mePwChange"> 
        <h2>비밀번호 재설정</h2>
        <p>비밀번호를 변경해주세요. <br> 다른 아이디나 사이트에서 사용한 적 없는 안전한 비밀번호로 변경해 주세요.</p>
        <ul>
        	<span id="span_id">* 아이디</span>
        	<c:if test="${not empty requestScope.password_id}">
            	<li>
                	<input type="text" id="fake_id" name="fake_id" disabled="disabled" value="${requestScope.password_id}" >
               		<input type="hidden" id="id" name="id" value="${requestScope.password_id}">
            	</li>
            </c:if>
            <c:if test="${empty requestScope.password_id}">
            	<li>
                	<input type="text" id="fake_id" name="fake_id" disabled="disabled" value="${requestScope.id}" >
               		<input type="hidden" id="id" name="id" value="${requestScope.id}">
            	</li>
            </c:if>
            <li>
                <input type="password" id="new_pw" name="new_pw" value="${requestScope.new_pw}" placeholder="새 비밀번호 입력">
                <span>${requestScope.errnewpassword}</span>
            </li>
            <li>
                <input type="password" id="new_pwCheck" name="new_pwCheck" value="${requestScope.new_pwCheck}" placeholder="새 비밀번호 확인">
                <span>${requestScope.errnewpassword_ck}</span>
            </li>
            <li>
                <button type="submit">
                	비밀번호 변경
                </button>
            </li>
        </ul>
    </form>
</body>
</html>