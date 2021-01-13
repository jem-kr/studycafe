<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 정보</title>
    <link rel="stylesheet" href="${contextPath}/css/meDetailView.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
  	<script type="text/javascript">
  		function check_delete() {
  			if(confirm("고객님의 모든 정보가 삭제됩니다. 정말 삭제하시겠습니까?")==true){
  				location.href='<%=NoForm%>meDelete&id=${sessionScope.loginfo.id}';
  			}else{
  				return false;		
  			}
		}
  	</script>
</head>
<body>
    <section class="member">
    	<input type="hidden" name="command" value="meUpdate">
        <div> 
            <h2>회원 상세 정보</h2>
        </div>
        <ul>
        	<c:if test="${not empty requestScope.update_bean}">
            	<h3>${requestScope.update_bean.name}님의 상세 정보 입니다.</h3>
            </c:if>
            <c:if test="${empty requestScope.update_bean}">
            	<h3>${requestScope.bean.name}님의 상세 정보 입니다.</h3>
            </c:if>
            <li>
                <label for="name">
                    이름
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="name" name="name" value="${requestScope.update_bean.name}" disabled=disabled >
	                <input type="hidden" id="name" name="name" value="${requestScope.update_bean.name}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="name" name="name" value="${requestScope.bean.name}" disabled=disabled >
	                <input type="hidden" id="name" name="name" value="${requestScope.bean.name}">
                </c:if>
            </li>
            <li>
                <label for="gender">
                    성별
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="gender" name="gender" value="${requestScope.update_bean.gender}" disabled=disabled >
	                <input type="hidden" id="gender" name="gender" value="${requestScope.update_bean.gender}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="gender" name="gender" value="${requestScope.bean.gender}" disabled=disabled >
	                <input type="hidden" id="gender" name="gender" value="${requestScope.bean.gender}">
                </c:if>
            </li>
            <li>
                <label for="birth">
                    생년월일
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="birth" name="birth" value="${requestScope.update_bean.birth}" disabled=disabled >
	                <input type="hidden" id="birth" name="birth" value="${requestScope.update_bean.birth}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="birth" name="birth" value="${requestScope.bean.birth}" disabled=disabled >
	                <input type="hidden" id="birth" name="birth" value="${requestScope.bean.birth}">
                </c:if>
            </li>
            <li>
                <label for="phone">
                    휴대폰 번호
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="phone" name="phone" value="${requestScope.update_bean.phone}" disabled=disabled>
	                <input type="hidden" id="phone" name="phone" value="${requestScope.update_bean.phone}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="phone" name="phone" value="${requestScope.bean.phone}" disabled=disabled>
	                <input type="hidden" id="phone" name="phone" value="${requestScope.bean.phone}">
                </c:if>
            </li>
            <li>
                <label for="email">
                    이메일 주소
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="email" name="email" value="${requestScope.update_bean.email01}@${requestScope.update_bean.email02}" disabled=disabled>
	                <input type="hidden" id="email" name="email" value="${requestScope.update_bean.email01}@${requestScope.update_bean.email02}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="email" name="email" value="${requestScope.bean.email01}@${requestScope.bean.email02}" disabled=disabled>
	                <input type="hidden" id="email" name="email" value="${requestScope.bean.email01}@${requestScope.bean.email02}">
                </c:if>
            </li>
            <li>
                <label for="pwquestion">
                    비밀번호 찾기 > 질문
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="pwquestion" name="pwquestion" value="${requestScope.update_bean.pwquestion}" disabled=disabled>
	                <input type="hidden" id="pwquestion" name="pwquestion" value="${requestScope.update_bean.pwquestion}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="pwquestion" name="pwquestion" value="${requestScope.bean.pwquestion}" disabled=disabled>
	                <input type="hidden" id="pwquestion" name="pwquestion" value="${requestScope.bean.pwquestion}">
                </c:if>
            </li>
            <li>
                <label for="pwanswer">
                    비밀번호 찾기 > 답변
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="pwanswer" name="pwanswer" value="${requestScope.update_bean.pwanswer}" disabled=disabled>
	                <input type="hidden" id="pwanswer" name="pwanswer" value="${requestScope.update_bean.pwanswer}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="pwanswer" name="pwanswer" value="${requestScope.bean.pwanswer}" disabled=disabled>
	                <input type="hidden" id="pwanswer" name="pwanswer" value="${requestScope.bean.pwanswer}">
                </c:if>
            </li>
            <li>
                <label for="visit">
                   방문 목적
                </label>
                <c:if test="${not empty requestScope.update_bean}">
	                <input type="text" id="visit" name="visit" value="${requestScope.update_bean.visit}" disabled=disabled>
	                <input type="hidden" id="visit" name="visit" value="${requestScope.update_bean.visit}">
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
	                <input type="text" id="visit" name="visit" value="${requestScope.bean.visit}" disabled=disabled>
	                <input type="hidden" id="visit" name="visit" value="${requestScope.bean.visit}">
                </c:if>
            </li>
            <li>
                <label for="agreement">개인정보 수집 및 이용 동의</label>
                <c:if test="${not empty requestScope.update_bean}">
                	<input type="text" id="agreement" name="agreement" value="${requestScope.update_bean.agreement}" disabled=disabled>
                </c:if>
                <c:if test="${empty requestScope.update_bean}">
                	<input type="text" id="agreement" name="agreement" value="${requestScope.bean.agreement}" disabled=disabled>
                </c:if>
            </li>
            <li class="edit">
	            <a href="<%=NoForm%>meDelete&id=${sessionScope.loginfo.id}" onclick="return check_delete();">
	               <i class="fas fa-user-slash">&nbsp;삭제</i>
	       		</a>
	       		<a href="<%=NoForm%>meUpdate&id=${sessionScope.loginfo.id}">
	               <i class="fas fa-user-edit">&nbsp;수정</i>
	       		</a>
            </li>
        </ul>
    </section>
</body>
</html>