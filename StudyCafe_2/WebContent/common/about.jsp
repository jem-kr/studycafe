<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
 
 <%
	int offset =3; //오프 셋 
	int content = twelve - 2 * offset; //12 - 2 * 오프셋
%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	$(document).ready(function({
		
	});
</script>
<style>
	#shoptitle{
		padding-top: 40px;
		padding-bottom: 50px;
	}
	.aboutimg{
		max-height: 80%
	}
	.content{
		padding-bottom: 100px;
	}
</style>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>그... 스터디카페를 소개합니다.</title>
</head>
<body>
	<div class="content">
	<div class="container-fluid col-sm-offset-<%=offset%>">
		<div>
			<img id="shoptitle" class="aboutimg" alt="about1.png" src="${contextPath }/images/demo/about1.png" >
		</div>
		<div>
			<img id="shopintro" class="aboutimg" alt="about2.png" src="${contextPath }/images/demo/about2.png" >
		</div>
	</div>
	</div>
</body>
</html>