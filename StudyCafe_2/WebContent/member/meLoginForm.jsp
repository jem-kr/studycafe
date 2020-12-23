<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>StudyCafe HTML</title>
	<style type="text/css">
		
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<br><br><br><br>
	<div class="container">
 		 <h2>login</h2>
 		 <form class="form-horizontal" role="form" action="<%=YesForm%>" method="post">
 		 	 <input type="hidden" name="command" value="meLogin">
	   		 <div class="form-group">
	     		 <input id="id" name="id" type="text" class="form-control"  placeholder="아이디" >
	   		 </div>
	    	<div class="form-group">
	     		  <input id="password" name="password" type="password" class="form-control"  placeholder="비밀번호" >
	    	</div>
	   		<div class="form-group form-check">
	      	   	 <label class="form-check-label">
	       			 <input class="form-check-input" type="checkbox" name="remember"> id 저장하기
	     		 </label>
	    	</div>
	    	<button type="submit" class="btn btn-primary">로그인</button>
  		</form>
	</div>
</body>
</html>