<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>시설 소개</title>
		<style type="text/css">
				.containerbox {
					display: flex;
				    flex-direction: column;
				    justify-content: center;
				    align-items: center;
				    padding-top: 100px;
				    padding-bottom: 100px;
				    font-size: 15px;
				    
				}
				
				.containerbox h2 {
					display: flex;
					justify-content: center;
					width: 100%;
					font-size: 32px;
					font-weight: 400;
					padding-bottom: 30px;
				}
				
				.containerbox ul>li>a {
					border-radius: 0px;
					color: #111111;
					font-size: 15px;
					
				}
				
				.containerbox ul>li>a {
					background-color: white;
					font-size: 15px;
					color: #111111;
					
				}
				
				.containerbox ul>li>a:hover {
					background-color: white;
				}
				
				.containerbox ul.nav-pills>li.active>a, ul.nav-pills>li.active>a:focus,
					.nav-pills>li.active>a:hover {
					color: white;
					font-weight: bold;
					background-color: #ffb400;
					font-size: 15px;
				}
				
				.containerbox ul.nav-pills>li.active>a:checked{
					color: white;
					font-weight: bold;
					background-color: #ffb400;
					font-size: 15px;
				}
				
				.containerbox ul {
					width: 1000px;
					padding: 0px;
					border-bottom: 1px solid #ffb400;
					
				}
				
				.containerbox p {
					font-size: 16px;
					color: #6f6f6f;
					line-height: 23px;
					text-align: center;
					margin: 20px 0 40px 0;
				}
				
				.containerbox h3 {
					display: flex;
					justify-content: center;
					font-weight: bold;
					margin-top: 60px;
					margin-bottom: 60px;
					width: 100%;
				}
				
				.containerbox .tab-content>.active {
					display: block;
					padding: 40px;
				}
				
				.tab-content {
					width: 1000px;
					display: flex;
					justify-content: center;
					flex-direction: column;
				}
				
				.containerbox .tab-content>.active {
					display: block;
					padding: 0px;
					width: 1000px;
				}
				
				table {
					width: 1000px;
					display: flex;
					justify-content: center;
				}
				
				tr {
					width: 1000px;
				}
				
				td {
					padding: 10px;
				}
				
				img {
					margin: 0px;
				}
				figure{
					background-color: white;
				}
				
				.col-md-6{
					padding:30px;
				}
				.tab-content p{
					margin: 0px;
   					padding: 20px 20px 20px 40px;
   					color: white;
   					font-weight: bold;
   					font-size: 20px;
   					font-family: "맑은 고딕";
   					background: #222222;
   					line-height: 30px;
   					text-align: left;
   				
				}
				.comment{
					font-size: 16px;
					font-weight: normal;
				}
		</style>
		<script type="text/javascript">
			$(document).ready(function name() {
				$("a.active").checked();
			});
		</script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	    <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
</head>
<body>
	<br>

	<div class="containerbox">
		<h2>시설 소개</h2>
		<p>이용자에게 최고급 시설로 보다 넓게 구성된 독립 공간을 제공하는 프리미엄급 각종 모임 전문 공간 입니다.</p>
		<br>
		<!-- Nav pills -->
		<ul class="nav nav-pills" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="pill" href="${contentPath}/#home">내부 시설(다인석)</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="pill"
				href="${contentPath}/#menu1">내부 시설(개인석)</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="pill"
				href="${contentPath}/#menu2">편의 시설</a></li>
		</ul>


		<!-- Tab panes -->
		<div class="tab-content">
			<div id="home" class="container tab-pane active">
				<br>
				<h3>내부 시설(다인석)</h3>
				<br>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic1">
							<figure>
								<img src="${contextPath}/images/화이트보드.png" alt="img01" width="500" height="400" class="img-responsive" />
							</figure>
							<div class="comment">
									<p>크고 편안한 색상의 화이트 보드<br><b class="comment">(보드마카/지우개 제공)</b></p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic2">
							<figure>
								<img src="${contextPath}/images/chair.png" alt="img02" width="500" height="400" class="img-responsive" />
									<p>장시간 이용에도 불편함이 없는<br>최고급 가변형 등받이 메쉬의자</p>
							</figure>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic3">
							<figure>
								<img src="${contextPath}/images/prFac_room.png" alt="img03" width="500" height="400" class="img-responsive" />
									<p>넉넉한 테이블 공간을 위한 <br>900~1,000mm 의 폭넓은 책상</p>
							</figure>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic4">
							<figure>
								<img src="${contextPath}/images/빔프로젝터.png" alt="img04" width="500" height="400" class="img-responsive" />
									<p>
										원활한 회의를 위한 <br>빔프로젝터 제공
									</p>
							</figure>
						</div>
					</div>
				</div>
				
			</div>
			<div id="menu1" class="container tab-pane fade">
				<br>
				<h3>내부 시설(개인석)</h3>
				<br>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic1">
							<figure>
								<img src="${contextPath}/images/개인석1.jpeg" alt="img01" width="500" height="400" class="img-responsive" />
							</figure>
							<div class="comment">
									<p>테이블<br><b class="comment">1m 너비의 넓고 쾌적한 책상</b></p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic4">
							<figure>
								<img src="${contextPath}/images/개인석4.png" alt="img02" width="500" height="400" class="img-responsive" />
									<p>의자 소음 차단<br><b class="comment">의자 소음 방지 커버로 학습에만 집중 가능</b></p>
							</figure>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic3">
							<figure>
								<img src="${contextPath}/images/개인석2.jpg" alt="img03" width="500" height="400" class="img-responsive" />
									<p>개인 전용 콘센트<br><b class="comment">개인 좌석별 전용 콘센트</b></p>
							</figure>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic4">
							<figure>
								<img src="${contextPath}/images/개인석3.jpg" alt="img04" width="500" height="400" class="img-responsive" />
									<p>눈이 편안한 조명<br><b class="comment">조도 변경과 타이머 기능</b></p>
							</figure>
						</div>
					</div>
				</div>
			</div>
			<div id="menu2" class="container tab-pane fade">
				<br>
				<h3>편의 시설</h3>
				<br>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic1">
							<figure>
								<img src="${contextPath}/images/프린트.jpg" alt="img01" width="500" height="400" class="img-responsive" />
							</figure>
							<div class="comment">
									<p>프린트 및 노트북 완비 <br><b class="comment">( 칼라 / 흑백 )</b></p>
									
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic2">
							<figure>
								<img src="${contextPath}/images/사물함.jpg" alt="img02" width="500" height="400" class="img-responsive" />
									<p>스마트 사물함<br><b class="comment">(당일사용 무료 / 월 사용료 1만원)</b></p>
							</figure>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- start portfolio item -->
					<div class="col-md-6">
						<div class="pic3">
							<figure>
								<img src="${contextPath}/images/세면대.jpg" alt="img03" width="500" height="400" class="img-responsive" />
									<p>로비&입장 대기공간 <br><b class="comment">내부세면대( 비누폼 , 핸드타올 ) , 쇼파테이블</b></p>
							</figure>
						</div>
					</div>
					<div class="col-md-6">
						<div class="pic4">
							<figure>
								<img src="${contextPath}/images/카페테리아.png" alt="img04" width="500" height="400" class="img-responsive" />
									<p>카페테리아<br><b class="comment">얼음 , 냉장고 , 기타음료 , 종이컵 , 티백 등</b></p>
							</figure>
						</div>
					</div>
				</div>
		</div>
	</div>
	</div>
</body>
</html>