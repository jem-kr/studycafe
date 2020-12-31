<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		<script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function updateForm(){
	location.href='<%=NoForm%>noUpdate&num=${bean.num}&${requestScope.parameters}';
}

function delconfirm(){
	if(confirm("공지사항을 삭제하겠습니까?")==true){
		location.href='<%=NoForm%>noDelete&num=${bean.num}&${requestScope.parameters}';
	}else{
		return;		
	}
	
}
</script>
<style type="text/css">
	table{
		width: 90%;
	}
	.thead{
		text-align:center;
	}
	.tcontent{
		min-height: 100px;
		
	}
	.panel{
	}
	.notice h2{
		padding-top:100px;
		font-size: 32px;
        color: #111111;
        border-bottom: 2px solid #111111;
        text-align: center;
        line-height: 100%;
        padding-bottom: 20px;
	}
	.notice h6{
		padding-bottom: 20px;
	}
	#disqus_thread{
		padding-top: 30px;
		max-width: 80%;
		padding-left: 20%;
		color: black;
	}
</style>
</head>
<%
	int myoffset = 2; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%> notice">
		<h2 align="center" class="headline">공지사항</h2>
		<h6 align="center" class="headline">그...스터디 카페의 정보와 소식을 확인하세요.</h6>
		<div class="panel panel-default ">
			<div class="panel-body">
				<div >
					<table class="table table-striped">
					<thead class="thead">
						<tr>
							<th width=20%>제목</th>
							<th width=80%> ${bean.title }</th>
						</tr>
					</thead>
					
						<tr>
							<td colspan="2" class="tcontent">						
								<div style="white-space: pre;"> ${bean.content } </div></td>
						</tr>
					<tr>
							<c:if test ="${applicationScope.debugMode == true }">
									디버그 모드가 true이면 보입니다.<br>
									${applicationScope.uploadedPath}/${bean.image}
								</c:if>
								<c:if test="${not empty bean.image}">
								<td>
									<img src="${contextPath}/upload/${bean.image}"
										class="img-thumbnail" width="200" height="200"
										alt="image">
								</td>
								</c:if>
								<c:if test="${empty bean.image}">
									<td>
									<input type="hidden">
									</td>
								</c:if>
								<c:if test="${bean.image == ''}">
									<td>
									<input type="hidden">
									</td>
								</c:if>
							
						</tr>
					</table>
				</div>
				<div>
				<hr>
				</div>
				<div class="row">
				<div class="col-sm-12 text-center" >
					<!-- <button  type="button" class="btn btn-primary" onclick="history.back();">
						목록보기</button>  -->
					<a href="<%=NoForm%>noList&${requestScope.parameters}" class="btn btn-primary" role="button">목록보기</a>	
						
						&nbsp;&nbsp;
						<c:if test="${whologin==2 }">
						<a href="<%=NoForm%>noUpdate&num=${bean.num}&${requestScope.parameters}" class="btn btn-primary" role="button">수정하기</a>
						</c:if>
						
						&nbsp;&nbsp;
						<c:if test="${whologin==2 }">
						<button class="btn btn-default btn-danger" type="button" onclick="delconfirm();">삭제하기</button>
						</c:if>
				</div>
				</div>
			</div>
			<!-- end panel-body -->
		</div>
	</div>
	
	<div id="disqus_thread" align="center"></div>
	<script>
    /**
    *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
    *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables    */
    /*
    var disqus_config = function () {
    this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
    this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
    };
    */
    (function() { // DON'T EDIT BELOW THIS LINE
    var d = document, s = d.createElement('script');
    s.src = 'https://studycafe.disqus.com/embed.js';
    s.setAttribute('data-timestamp', +new Date());
    (d.head || d.body).appendChild(s);
    })();
	</script>
<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
	
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
	
</body>
</html>