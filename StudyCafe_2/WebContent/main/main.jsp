<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	<!-- Bootstrap core CSS -->
	<link href="${contextPath }/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<!-- Custom styles for this template -->
	<link href="${contextPath }/css/style.css" rel="stylesheet">
	<title>StudyCafe HTML</title>
	<style type="text/css">
	.blackbar {
		padding-top: 10px;
	}
	
	.blacktext {
		color: white;
	}
	
	.map {
		text-align: center;
		max-height: 100%;
		margin: 0px auto;
	}
	</style>
	

</head>
<body id="page-top">
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<br>
					<br>
					<br>
					<br>
					<br>
					<div class="section-title">
						<h2>For Study</h2>
						<p>
							시설업의 강자가 만든 그...스터디카페는 <br>편안히 머물 수 있는 공간을 제공해 지치지 않고 처음의
							다짐, 열정을 그대로 유지해줍니다.
						</p>
					</div>
				</div>
			</div>
			<br>
			<div class="row row-0-gutter">
				<!-- start portfolio item -->
				<div class="col-md-6 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="${contextPath}/images/demo/main01.png" alt="img01"
								class="img-responsive" />
							<figcaption>
								<h2>1인석</h2>
								<a href="#" data-toggle="modal" data-target="#Modal-1">더보기</a>
							</figcaption>
						</figure>
					</div>
				</div>

				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-6 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="${contextPath}/images/demo/main02.png" alt="img02"
								class="img-responsive" />
							<figcaption>
								<h2>다인실</h2>
								<a href="#" data-toggle="modal" data-target="#Modal-2">더보기</a>
							</figcaption>
						</figure>
					</div>
				</div>
			</div>
		</div>
	</section>
	<br>
	<hr>
	<section id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-title">
						<h2>BRANCH</h2>
						<p>가까운 그...스터디카페를 확인해 보세요.</p>
						<br>
					</div>
				</div>
			</div>


			<div class="row">
				<!-- team member item -->
				<div class="col-md-4">
					<div class="team-item">
						<div class="team-image">
							<img src="${contextPath}/images/demo/branch01.png"
								class="img-responsive" alt="author">
						</div>
						<div class="team-text">
							<h3>인천 부평점</h3>
							<span class="badge badge-secondary">best</span>
							<p>
								부평구 부평로 366<br>(부평동 1425-17), 8F
							</p>
						</div>
					</div>
				</div>
				<!-- end team member item -->
				<!-- team member item -->
				<div class="col-md-4">
					<div class="team-item">
						<div class="team-image">
							<img src="${contextPath}/images/demo/branch02.png"
								class="img-responsive" alt="author">
						</div>
						<div class="team-text">
							<h3>서울 신촌점</h3>
							<span class="badge badge-secondary">new</span>
							<p>
								마포구 백범로 23<br>(신수동 63-13), B1
							</p>
						</div>
					</div>
				</div>
				<!-- end team member item -->
				<!-- team member item -->
				<div class="col-md-4">
					<div class="team-item">
						<div class="team-image">
							<img src="${contextPath}/images/demo/branch03.png"
								class="img-responsive" alt="author">
						</div>
						<div class="team-text">
							<h3>서울 당산점</h3>
							<span class="badge badge-secondary">new</span>
							<p>
								영등포구 당산로 11-1<br>(법정동 14-20), 3F
							</p>
						</div>
					</div>
				</div>
				<!-- end team member item -->
			</div>
		</div>
	</section>
	<br>
	<hr>
	<section>
		<div class="map">
			<h4>오시는 길</h4>
			<div id="staticMap" class="map img-responsive"
				style="width: 50%; height: 350px;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4f3aafed6e3a0f3623ac84933962f0e3"></script>
			<script>
				// 이미지 지도에 표시할 마커입니다
				// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
				var markers = [
						{
							position : new kakao.maps.LatLng(
									37.552671523857214, 126.93780474055818)
						},
						{
							position : new kakao.maps.LatLng(
									37.552671523857214, 126.93780474055818),
							text : '그...스터디카페' // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
						} ];

				var staticMapContainer = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
				staticMapOption = {
					center : new kakao.maps.LatLng(37.552671523857214,
							126.93780474055818), // 이미지 지도의 중심좌표
					level : 4, // 이미지 지도의 확대 레벨
					marker : markers
				// 이미지 지도에 표시할 마커 
				};

				// 이미지 지도를 생성합니다
				var staticMap = new kakao.maps.StaticMap(staticMapContainer,
						staticMapOption);
			</script>
			<p>서울시 마포구 백범로 23(신수동 63-13), B1</p>
		</div>
	</section>
	<br>
	<hr>


	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-title">
						<h2>Contact Us</h2>
						<p>
							문의사항이 있다면 언제든 메세지를 보내주세요.<br>
						</p>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-12 text-center">
					<form name="sentMessage" action="<%=YesForm%>" id="contactForm"
						novalidate="" method="post">
						<input type="hidden" name="command" value="QAsend">

						<div class="row">
							<div class="col-md-12">

								<div class="form-group">
									<input type="text" class="form-control" id="email" name="email"
										value=""
										data-validation-required-message="Please enter your email."
										placeholder="Your email *">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<textarea class="form-control" placeholder="Your Message *"
										id="message" name="e_msg" required=""
										data-validation-required-message="Please enter a message."></textarea>
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="row">
							<div class="col-lg-12 text-center">
								<div id="success"></div>
								<button type="submit" class="btn btn-warning">Send
									Message</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</section>


	<br>
	<br>



	<!-- Bootstrap core JavaScript
         ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/SmoothScroll.js"></script>
	<script src="js/theme-scripts.js"></script>
</body>
</html>