<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
 
 <%
	int offset =1; //오프 셋 
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
</style>
<head>
<meta charset="UTF-8">
<title>그... 스터디카페를 소개합니다.</title>
</head>
<body>
	<div class="container-fluid col-sm-offset-<%=offset%>">
		<div>
			<img id="shoptitle" class="aboutimg" alt="about1.png" src="${contextPath }/images/demo/about1.png" >
		</div>
		<div>
			<img id="shopintro" class="aboutimg" alt="about2.png" src="${contextPath }/images/demo/about2.png" >
		</div>
	</div>

</body>
</html>