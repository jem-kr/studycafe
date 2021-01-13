<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" href="${contextPath}/css/meUpdate.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
</head>
<body>
     <form class="member" action="" method="POST">
    	<input type="hidden" name="command" value="meUpdate">
        <div> 
            <h2>회원 정보 수정</h2>
        </div>
        <ul>
           <c:if test="${not empty requestScope.bean.name}">
            	<h3>${requestScope.bean.name}님의 상세 정보 입니다.</h3>
            </c:if>
            <c:if test="${empty requestScope.bean.name}">
            	<h3>${requestScope.name}님의 상세 정보 입니다.</h3>
            </c:if>
            <li>
                <label for="name">
                    이름
                </label>
                <c:if test="${not empty requestScope.bean.name}">
                	<input type="text" id="name" name="name" value="${requestScope.bean.name}">
                </c:if>
                <c:if test="${empty requestScope.bean.name}">
                	<input type="text" id="name" name="name" value="${requestScope.name}">
                </c:if>
            </li>
            
            <span>${requestScope.errname}</span>
            <li id="gender">
                <label for="gender">
                    성별
                </label>
                <div>
                    <c:if test="${requestScope.bean.gender == '남'}">
	                    <input type="radio" id="gender01" name="gender" value="남" checked="checked">
	                    <label for="gender01">남</label>
	                </c:if>
	                <c:if test="${requestScope.bean.gender != '남'}">
	                    <input type="radio" id="gender01" name="gender" value="남">
	                    <label for="gender01">남</label>
	                </c:if>
	                <c:if test="${requestScope.bean.gender == '여'}">
	                    <input type="radio" id="gender02" name="gender" value="여" checked="checked">
	                    <label for="gender02">여</label>
	                </c:if>
	                <c:if test="${requestScope.bean.gender != '여'}">
	                    <input type="radio" id="gender02" name="gender" value="여">
	                    <label for="gender02">여</label>
	                </c:if>
                </div>  
            </li>
            <span>${requestScope.errgender}</span>
            <li>
                <label for="birth">
                    생년월일
                </label>
                <c:if test="${not empty requestScope.bean.birth}">
                	<input type="text" id="birth" name="birth" value="${requestScope.bean.birth}">
                </c:if>
                <c:if test="${empty requestScope.bean.birth}">
                	<input type="text" id="birth" name="birth" value="${requestScope.birth}">
                </c:if>
            </li>
            <span>${requestScope.errbirth}</span>
            <li>
                <label for="phone">
                    휴대폰 번호
                </label>
                <c:if test="${not empty requestScope.bean.birth}">
                	<input type="text" id="phone" name="phone" value="${requestScope.bean.phone}">
                </c:if>
                <c:if test="${empty requestScope.bean.birth}">
                	<input type="text" id="phone" name="phone" value="${requestScope.phone}">
                </c:if>
            </li>
            <span>${requestScope.errphone}</span>
            <li id="email">
                <label for="email01">
                    이메일 주소
                </label>
                <div>
                	<c:if test="${not empty requestScope.bean.email01}">
                    	<input type="text" id="email01" name="email01" value="${requestScope.bean.email01}" title="이메일 앞 주소 입력" >
                    </c:if>
                    <c:if test="${empty requestScope.bean.email01}">
                    	<input type="text" id="email01" name="email01" value="${requestScope.email01}" title="이메일 앞 주소 입력" >
                    </c:if>
                    &nbsp;
                    @
                    &nbsp;
                    <select name="email02" id="email02">
                        <c:if test="${requestScope.bean.email02 == 'naver.com'}">
                        	<option value="naver.com" selected="selected">naver.com</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 != 'naver.com'}">
                        	<option value="naver.com">naver.com</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 == 'daum.net'}">
                        	<option value="daum.net" selected="selected">daum.net</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 != 'daum.net'}">
                        	<option value="daum.net">daum.net</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 == 'google.com'}">
                        	<option value="google.com" selected="selected">google.com</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 != 'google.com'}">
                        	<option value="google.com">google.com</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 == 'nate.com'}">
                        	<option value="nate.com" selected="selected">nate.com</option>
                        </c:if>
                        <c:if test="${requestScope.bean.email02 != 'nate.com'}">
                        	<option value="nate.com">nate.com</option>
                        </c:if>
                    </select>
                </div>
            </li>
            <span>${requestScope.erremail01}</span>
            <li id="pwquestion">
                <label for="pwquestion">
                    비밀번호 찾기 > 질문
                </label>
                <select name="pwquestion" id="pwquestion">
                	<c:if test="${requestScope.bean.pwquestion == '태어난 지역은?'}">
                    	<option value="태어난 지역은?" selected="selected">태어난 지역은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion != '태어난 지역은?'}">
                    	<option value="태어난 지역은?">태어난 지역은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion == '어렸을 때 다녔던 초등학교 이름은?'}">
                    	<option value="어렸을 때 다녔던 초등학교 이름은?" selected="selected">어렸을 때 다녔던 초등학교 이름은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion != '어렸을 때 다녔던 초등학교 이름은?'}">
                    	<option value="어렸을 때 다녔던 초등학교 이름은?">어렸을 때 다녔던 초등학교 이름은?</option>
                    </c:if>
                    <c:if test="${requestScope.bean.pwquestion == '가장 존경하는 인물은?'}">
                    	<option value="가장 존경하는 인물은?" selected="selected">가장 존경하는 인물은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion != '가장 존경하는 인물은?'}">
                    	<option value="가장 존경하는 인물은?">가장 존경하는 인물은?</option>
                    </c:if>
                    <c:if test="${requestScope.bean.pwquestion == '키우던 애완동물의 이름은?'}">
                    	<option value="키우던 애완동물의 이름은?" selected="selected">키우던 애완동물의 이름은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion != '키우던 애완동물의 이름은?'}">
                    	<option value="키우던 애완동물의 이름은?">키우던 애완동물의 이름은?</option>
                    </c:if>
                     <c:if test="${requestScope.bean.pwquestion == '가장 기억에 남는 경험은?'}">
                    	<option value="가장 기억에 남는 경험은?" selected="selected">가장 기억에 남는 경험은?</option>
                    </c:if>
                	<c:if test="${requestScope.bean.pwquestion != '가장 기억에 남는 경험은?'}">
                    	<option value="가장 기억에 남는 경험은?">가장 기억에 남는 경험은?</option>
                    </c:if>
                </select>
            </li>
            <li>
                <label for="pwanswer">
                    비밀번호 찾기 > 답변
                </label>
                <c:if test="${not empty requestScope.bean.pwanswer}">
                	<input type="text" id="pwanswer" name="pwanswer" value="${requestScope.bean.pwanswer}">
                </c:if>
                 <c:if test="${empty requestScope.bean.pwanswer}">
                	<input type="text" id="pwanswer" name="pwanswer" value="${requestScope.pwanswer}">
                </c:if>
            </li>
             <span>${requestScope.errpwanswer}</span>
            <li id="visit">
                <label for="visit">
                    방문 목적
                </label>
                <div>
                	<c:if test="${fn:contains(requestScope.bean.visit , '좌석 예약') == true}">
	                    <input type="checkbox" id="visit01" name="visit" value="좌석 예약" checked="checked">
	                    <label for="visit01">좌석 예약</label>
                    </c:if>
                    <c:if test="${fn:contains(requestScope.bean.visit , '좌석 예약') == false}">
	                    <input type="checkbox" id="visit01" name="visit" value="좌석 예약">
	                    <label for="visit01">좌석 예약</label>
                    </c:if>
                    <c:if test="${fn:contains(requestScope.bean.visit , '시설 확인') == true}">
	                    <input type="checkbox" id="visit02" name="visit" value="시설 확인" checked="checked">
                    	<label for="visit02">시설 확인</label>
                    </c:if>
                    <c:if test="${fn:contains(requestScope.bean.visit , '시설 확인') == false}">
	                    <input type="checkbox" id="visit02" name="visit" value="시설 확인">
                    	<label for="visit02">시설 확인</label>
                    </c:if>
                    <c:if test="${fn:contains(requestScope.bean.visit , '이용요금 확인') == true}">
	                    <input type="checkbox" id="visit03" name="visit" value="이용요금 확인" checked="checked">
                  		<label for="visit03">이용요금 확인</label>
                    </c:if>
                    <c:if test="${fn:contains(requestScope.bean.visit , '이용요금 확인') == false}">
	                    <input type="checkbox" id="visit03" name="visit" value="이용요금 확인">
                  		<label for="visit03">이용요금 확인</label>
                    </c:if>
                </div>
            </li>
            <li class="edit">
                <button type="submit">
                   	<i class="far fa-check-circle">&nbsp;완료</i>
                </button>
            </li>
        </ul>
    </form>
</body>
</html>