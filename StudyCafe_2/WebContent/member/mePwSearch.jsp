<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
     <link type="text/css" href="${contextPath}/css/mePwSearch.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
    <script type="text/javascript">
    	function isCheckForm() {
			var isCheck = $('#isCheck').val();
			
			if (isCheck == 'false') {
				alert('본인인증을 해주세요.');
				return false;
			}
		}
    	
    	function input_answer() {
    		document.pw_search.isCheck.value = true;
		}
    	
    </script>
</head>
<body>
    <form name="pw_search" class="pw_search" method="POST" action="<%=YesForm%>">
        <input type="hidden" name="command" value="mePwSearch"> 
        <input type="hidden" id="isCheck" name="isCheck" value="false">
        <h2>비밀번호 찾기</h2>
        <ul>
            <li>
                <input type="text" id="id" name="id" value="${requestScope.id}" placeholder="아이디">
                <span>${requestScope.errid}</span>
            </li>
            <li>
                <input type="text" id="phone" name="phone" value="${requestScope.phone}" placeholder="휴대폰 번호 ( - 하이픈 없이 입력하세요.)">
                <span>${requestScope.errphone}</span>
            </li>
           <li class="pwCheck">
                <label id="pwCheck">
                    본인인증을 해주세요.
                    <button id="pwCheck" name="pwCheck">본인인증</button>
                </label>
            </li>
            <c:if test="${not empty requestScope.bean}"><!-- requestScope.bean 비밀번호 찾기 질문 -->
	            <h3>본인인증</h3>
				<li>
	                <input type="text" id="pwquestion" name="pwquestion" disabled="disabled" value="${requestScope.bean.pwquestion}" >
	            </li>    
	            <li>
	                <input type="text" id="pwanswer" name="pwanswer" value="${requestScope.pwanswer}" placeholder="해당 질문에 맞는 답변을 입력하세요." onkeyup="input_answer();">
	                <span>${requestScope.errpwanswer}</span>
	            </li> 
	             
	        </c:if>
	        <li>
            	<span>${requestScope.errpassword}</span>
                <button onclick="return isCheckForm();">
                	비밀번호 찾기
                </button>
          	</li>
           
            <c:if test="${not empty requestScope.password_find}">
            <h3>아래의 정보를 확인하세요.</h3>
	           
	            <li class="one1"><b>${requestScope.password_msg}</b></li>
	            <li class="one">
	            	<i class="fas fa-angle-double-right">&nbsp;&nbsp;${requestScope.password_find}</i>
	            </li>
	            <br>
	            <li class="one"><b>로그인을 희망하시는 경우, 아래 링크를 클릭해주세요.</b></li>
	            <li><a href="<%=NoForm%>meLogin">로그인</a></li>
            </c:if>
        </ul>
    </form>
</body>
</html>