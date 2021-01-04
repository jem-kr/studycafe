<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="mypkg.bean.Member"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="./../common/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link type="text/css" href="${contextPath}/css/meInsert.css" rel="stylesheet"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
	function check_Id(  ){
		var id = $('#id').val();
			if( id.length == 0 ){
				alert('아이디를 입력해 주세요') ;
				document.myform.id.focus() ; 
				return false ;
			}
			var url='<%=NoForm%>meIdCheck&id=' + id ;
			//alert(url);
			var windowW = 300;  // 창의 가로 길이
	        var windowH = 150;  // 창의 세로 길이
	        
	        var left = Math.ceil((window.screen.width - windowW)/2);
	        var top = Math.ceil((window.screen.height - windowH)/2);
	        
			window.open(url,"popup","l top="+top+", left="+left+", height="+windowH+", width="+windowW);


		}
	
	
		function isCheckFalse() {
			document.myform.isCheck.value = false;
		}
		
		function checkForm() {
			var isCheck = document.myform.isCheck.value;
			//alert( isCheck ) ;
			if (isCheck == 'false') {
				alert('아이디 중복확인을 해주세요.');
				return false;
			}
		}
	
	</script>
</head>
<body>
    <form class="member" name="myform" method="post" action="<%=YesForm%>">
    <input type="hidden" name="command" value="meInsert">
    <input type="hidden" name="isCheck" value="false">
        <div> 
            <h2>회원가입</h2>
        </div>
        <ul>
            <h3>필수 입력</h3>
            <li class="idpassword">
                <label for="id">
                    아이디
                </label>
                <input type="text" id="id" name="id" value="${requestScope.bean.id}" title="아이디입력" placeholder="아이디를 입력하세요." onkeyup="isCheckFalse();">
                <span>${requestScope.errid}</span>  
            </li>
            <li class="idCheck">
                <label id="idCheck">중복확인을 해주세요.
	                  <button id="idCheck" onclick="check_Id();">
	            	       	중복확인
	                  </button>
                </label>
            </li>
            <li class="idpassword">
                <label for="password">
                    비밀번호
                </label>
                <input type="password" id="password" name="password" value="${requestScope.bean.password}" title="비밀번호입력" placeholder="비밀번호를 입력하세요.">
                <span>${requestScope.errpassword}</span>
                
            </li>
            <li>
                <label for="pwCheck">
                    비밀번호 확인
                </label>
                <input type="password" id="pwCheck" name="pwCheck" value="${requestScope.pwCheck}" title="비밀번호 확인" placeholder="비밀번호를 입력하세요.">
                <span>${requestScope.errpwCheck}</span>
            </li>
            <li>
                <label for="name">
                    이름
                </label>
                <input type="text" id="name" name="name" value="${requestScope.bean.name}" title="이름 입력" placeholder="이름을 입력하세요.">
                <span>${requestScope.errname}</span>   
            </li>
            <li class="gender">
                <label for="gender">
                    성별
                </label>
                <input type="radio" id="gender01" name="gender" value="남">
                <label for="gender01">남</label>
                <input type="radio" id="gender02" name="gender" value="여">
                <label for="gender02">여</label>  
            </li>
            <span>${requestScope.errgender}</span>  
            <li class="birth">
                <label for="birth">
                    생년월일
                </label>
                <select name="year" id="year">
                	<option value="년" selected="selected">년</option>
                	<c:forEach var="i" begin="1920" end="2021" step="1">
                    	<option value="${i}">${i}</option>
                    </c:forEach>
                </select>
                <select name="month" id="month">
                    <option value="월" selected="selected">월</option>
                    <c:forEach var="i" begin="1" end="12" step="1">
                    	<c:if test="${i >= 10}">
                    		<option value="${i}">${i}</option>
                    	</c:if>
                    	<c:if test="${i < 10}">
                    		<option value="0${i}">0${i}</option>
                    	</c:if>
                    </c:forEach>
                </select>
                <select name="day" id="day">
                    <option value="일" selected="selected">일</option>
                    <c:forEach var="i" begin="1" end="31" step="1">
                    	<c:if test="${i >= 10}">
                    		<option value="${i}">${i}</option>
                    	</c:if>
                    	<c:if test="${i < 10}">
                    		<option value="0${i}">0${i}</option>
                    	</c:if>
                    </c:forEach>
                </select>
            </li>
            <span>${requestScope.errbirth}</span>  
            <li class="phone">
                <label for="phone">
                    휴대폰 번호
                </label>
                    <select name="hp_first" id="hp_first">
                        <option value="010" selected="selected">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="018">018</option>
                        <option value="018">019</option>
                    </select>
                    <input type="text" id="hp_second" name="hp_second" value="${requestScope.hp_second}" title="핸드폰번호 입력" placeholder="휴대폰 번호를 입력하세요.">
            </li>
            <span>${requestScope.errhp_second}</span>  
            <li class="email">
                <label for="email01">
                    이메일 주소
                </label>
                <input type="text" id="email01" name="email01" value="${requestScope.bean.email01}" title="이메일 앞 주소 입력" placeholder="이메일을 입력하세요.">
                @
                <select name="email02" id="email02">
                    <option value="naver.com" selected="selected">naver.com</option>
                    <option value="daum.net">daum.net</option>
                    <option value="google.com">google.com</option>
                    <option value="nate.com">nate.com</option>
                </select>
            </li>
       		 <span>${requestScope.erremail01}</span>  
       		 <br>
       		 <br>
            <div class="member_add">
                <h3>추가 입력</h3>
                <ul>
                    <li>
                        <label for="pwquestion">
                            비밀번호 찾기 > 질문
                        </label>
                        <select name="pwquestion" id="pwquestion">
                            <option value="-">질문을 선택하세요.</option>
                            <option value="태어난 지역은?">태어난 지역은?</option>
                            <option value="어렸을 때 다녔던 초등학교 이름은?">어렸을 때 다녔던 초등학교 이름은?</option>
                            <option value="가장 존경하는 인물은?">가장 존경하는 인물은?</option>
                            <option value="키우던 애완동물의 이름은?">키우던 애완동물의 이름은?</option>
                            <option value="가장 기억에 남는 경험은?">가장 기억에 남는 경험은?</option>
                        </select>
                         <span>${requestScope.errpwquestion}</span>  
                    </li>
                    <li>
                        <label for="pwanswer">
                            비밀번호 찾기 > 답변
                        </label>
                        <input type="text" id="pwanswer" name="pwanswer" value="" title="비밀번호 답변 입력" placeholder="해당 질문에 대한 답변을 입력하세요.">
                         <span>${requestScope.errpwanswer}</span>  
                    </li>
                    <li>
                        <label for="pwanswer">
                            방문 목적
                        </label>
                        <input type="checkbox" id="visit01" name="visit" value="좌석 예약">
                        <label for="visit01">좌석 예약</label>
                        <input type="checkbox" id="visit02" name="visit" value="시설 확인">
                        <label for="visit02">시설 확인</label>
                        <input type="checkbox" id="visit03" name="visit" value="이용요금 확인">
                        <label for="visit03">이용요금 확인</label>
                    </li>
                </ul>
            </div>

            <li class="agreement">
                <label for="agreement">개인정보 수집 및 이용 동의</label>
                <input type="checkbox" id="agreement" name="agreement" value="동의">
            </li>
            <span>${requestScope.erragreement}</span>
            <li>
                <button id="insert" onclick="return checkForm();" >회원가입</button>
            </li>
         </ul>
        
    </form>
</body>
</html>