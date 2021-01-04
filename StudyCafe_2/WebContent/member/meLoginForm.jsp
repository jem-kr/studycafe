<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        .login{
            width: 410px;
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .login h2{
            font-size: 32px;
            color: #111111;
            border-bottom: 2px solid #111111;
            text-align: center;
            line-height: 100%;
            padding-bottom: 20px;
        }
        .login > ul{
            padding: 33px 0px 0px 0px;

        }
        .login > ul li{
            list-style: none;
            padding-bottom: 25px;
        }
        .login > ul li input{
            width: 100%;
            padding: 0px;
            box-sizing: border-box;
            height: 46px;
            text-indent: 12px;
        }
        .login > ul li input::-webkit-input-placeholder{
            font-size: 16px;
            color: #9fa19f;
            text-indent: 12px;
        }
        .login > ul li input[type="checkbox"]{
            position: absolute;
            left: -3000px;
        }
        .login > ul li input[type="checkbox"] + label{
            height: 36px;
            line-height: 36px;
        }
        .login > ul li input[type="checkbox"] + label::before{
            content: "";
            width: 18px;
            height: 18px ;
            border: 1px solid #666666;
            background: #ffffff;
            display: inline-block;
            vertical-align: -2px;
            margin-right: 10px;
        }
        .login li input[type="checkbox"]:checked + label::before{
        	background : url("./../images/check_icon.png") no-repeat #333333 center;
            border-color: #333333;
        }

        .login button{
            width: 100% ;
            height: 56px;
            background-color: #ffb400;
            line-height: 56px;
            font-size: 18px;
            color: #ffffff;
            border:#ffb400;
            font-weight: bold;
        }
        .login div{
            padding-bottom: 45px;
        }
        .login div ul{
            padding: 0px;
            display: flex;
            justify-content: center;
        }
        .login div ul li{
            list-style: none;
            padding: 0px 18px;
            position: relative;
        }
        .login div ul li~li:after{
           content: "";
           position: absolute;
           left: 0;
           top: 4px;
           height: 14px;
           width: 1px;
           background: #111111;
        }
        .login div ul li a{
            font-size: 14px;
            color: #111111;
        }
        .login div a:link{
            text-decoration: none;
        }
        .login span{
			color: red;
			font-weight: bold;
			font-size: 12px;
		}

    </style>
</head>
<body>
	  <form class="login" action="<%=YesForm%>" method="post">
	  	<input type="hidden" name="command" value="meLogin">
        <h2>로그인</h2>
	        <ul>
	            <li>
	            	<input id="id" name="id" type="text" value="${requestScope.id}" type="text" placeholder="아이디" title="아이디입력">
	            	<span>${requestScope.errid}</span>
	            </li>
	            
	            <li>
	            	<input id="password" name="password" value="${requestScope.password}" type="password" placeholder="비밀번호" title="비밀번호 입력">
	            	<span>${requestScope.errpassword}</span>
	            </li>
	            <li>
	                <input type="checkbox" id="id_save">
	                <label for="id_save">아이디저장</label>
	            </li>
	            <li>
	            	<span>${requestScope.err_message}</span>
	            	<button type="submit">로그인</button>
	            </li>
	        </ul>
	        <div>
	            <ul>
	                <li><a href="<%=NoForm%>meInsert">회원가입</a></li>
	                <li><a href="<%=NoForm%>meIdSearch">아이디 찾기</a></li>
	                <li><a href="<%=NoForm%>mePwSearch">비밀번호 찾기</a></li>
	            </ul>
	        </div>
	    </form>
</body>
</html>