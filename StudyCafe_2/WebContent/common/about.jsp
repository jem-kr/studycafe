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
		padding-top: 60px;
		padding-bottom: 80px;
	}
	.aboutimg{
		max-height: 100%;
		margin: 0px auto;
		padding-bottom: 50px;

	}
	.content{
	text-align: center;
	padding-bottom:80px;
	}
</style>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
     <link href="${contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<link href="${contextPath }/css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
<title>그... 스터디카페를 소개합니다.</title>
</head>
<body id="page-top">
	<div class="content" id="portfolio">
	<div class="container-fluid ">
		<div>
			<img id="shoptitle" class="aboutimg ot-portfolio-item img-responsive" alt="about1.png" src="${contextPath }/images/demo/about1.png" >
		</div>
		<div>
			<img id="shopintro" class="aboutimg ot-portfolio-item img-responsive" alt="about2.png" src="${contextPath }/images/demo/about2.png" >
		</div>
	</div>
	</div>
</body>
</html>