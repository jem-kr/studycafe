<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link type="text/css" href="${contextPath}/css/meInsert.css" rel="stylesheet"/>
</head>
<body>
    <form class="member">
        <div> 
            <h2>회원가입</h2>
        </div>
        <ul>
            <h3>필수 입력</h3>
            <li class="idpassword">
                <label for="id">
                    아이디
                </label>
                <input type="text" id="id" name="id" value="" title="아이디입력" placeholder="아이디를 입력하세요.">
                <span></span>  
            </li>
            <li class="idCheck">
                <label id="idCheck">중복확인을 해주세요.
                    <button id="idCheck" name="idCheck">중복확인</button>
                </label>
            </li>
            <li class="idpassword">
                <label for="password">
                    비밀번호
                </label>
                <input type="password" id="password" name="password" value="" title="비밀번호입력" placeholder="비밀번호를 입력하세요.">
                <span></span>
                
            </li>
            <li>
                <label for="pwCheck">
                    비밀번호 확인
                </label>
                <input type="password" id="pwCheck" name="pwCheck" value="" title="비밀번호 확인" placeholder="비밀번호를 입력하세요.">
                <span></span>
            </li>
            <li>
                <label for="name">
                    이름
                </label>
                <input type="text" id="name" name="name" value="" title="이름 입력" placeholder="이름을 입력하세요.">
                <span></span>   
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
            <li class="birth">
                <label for="birth">
                    생년월일
                </label>
                <select name="birth" id="birth">
                    <option value="birth">년</option>
                </select>
                <select name="birth" id="birth">
                    <option value="birth">월</option>
                </select>
                <select name="birth" id="birth">
                    <option value="birth">일</option>
                </select>
            </li>
            <li class="phone">
                <label for="phone">
                    휴대폰 번호
                </label>
                    <select name="phone" id="phone">
                        <option value="phone">010</option>
                    </select>
                    <input type="text" id="phone" name="phone" value="" title="핸드폰번호 입력" placeholder="휴대폰 번호 8자리를 입력하세요.">
            </li>
            <li class="email">
                <label for="email01">
                    이메일 주소
                </label>
                <input type="email" id="email01" name="email01" value="" title="이메일 앞 주소 입력" placeholder="이메일을 입력하세요.">
                @
                <select name="email02" id="email02">
                    <option value="email02">naver.com</option>
                </select>
            </li>
       
            <div class="member_add">
                <h3>추가 입력</h3>
                <ul>
                    <li>
                        <label for="pwquestion">
                            비밀번호 찾기 > 질문
                        </label>
                        <select name="pwquestion" id="pwquestion">
                            <option value="pwquestion">질문을 선택하세요.</option>
                        </select>
                    </li>
                    <li>
                        <label for="pwanswer">
                            비밀번호 찾기 > 답변
                        </label>
                        <input type="text" id="pwanswer" name="pwanswer" value="" title="비밀번호 답변 입력" placeholder="해당 질문에 대한 답변을 입력하세요.">
                    </li>
                    <li>
                        <label for="pwanswer">
                            방문 목적
                        </label>
                        <input type="checkbox" id="visit01" name="visit" value="스터디카페예약">
                        <label for="visit01">좌석 예약</label>
                        <input type="checkbox" id="visit02" name="visit" value="스터디카페예약">
                        <label for="visit02">시설 확인</label>
                        <input type="checkbox" id="visit03" name="visit" value="스터디카페예약">
                        <label for="visit03">이용요금 확인</label>
                    </li>
                </ul>
            </div>

            <li clase="agreement">
                <label for="agreement">개인정보 동의</label>
                <input type="checkbox" id="agreement">
            </li>
            <li>
                <button id="insert">회원가입</button>
            </li>
         </ul>
    </form>
</body>
</html>