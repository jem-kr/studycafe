<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 중복 체크</title>
	<script type="text/javascript">
		function meClose(isCheck) {
			//alert(isCheck);
			opener.document.myform.isCheck.value = isCheck ;
			self.close();
		}
	</script>
	<style type="text/css">
	body {
		margin: 0;
		paddin: 0;
	}
	
	.idck {
		display: flex;
		justify-content: center;
		flex-direction: column;
		text-align: center;
		padding-top: 35px;
	}
	
	
	.idck button{
            width: 100px ;
            height: 40px;
            background-color: #ffb400;
            line-height: 40px;
            font-size: 18px;
            color: #ffffff;
            border:#ffb400;
            font-weight: bold;
        }
	
	</style>
	</head>
	<body>
	<div class="idck">
		<div class="idck_body">
			<p>${requestScope.idCheck_msg}</p>
		</div>
		<br>
		<div class="idck_footer">
			<button type="button" onclick="meClose('${isCheck}');">
				CLOSE
			</button>
		</div>
	</div>
</body>
</html>