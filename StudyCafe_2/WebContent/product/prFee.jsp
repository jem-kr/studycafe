<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
 <%
	int offset =1; //오프 셋 
	int content = twelve - 2 * offset; //12 - 2 * 오프셋
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://kit.fontawesome.com/0bccbc6608.js" crossorigin="anonymous"></script>
	<link type="text/css" href="${contextPath }/css/pricelist.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>이용 안내</title>
<style type="text/css">
.prfeetitle{
	padding-top:30px;
	font-size:32px;
}
</style>
</head>
<body>
		<div class="container col col-sm-offset-<%=offset%> col-sm-<%=content%>">
		<div id="sub" style="position:relative; text-align: center;" >
		<div class="article_title">
			<h2 class=prfeetitle>이용안내</h2>
			<p>홀 내부를 보다 넓게 구성하고 특별제작 된 넓은 책상을 제공함으로써 이용자의 학습 공간이 여유롭습니다. <br>
			특히 모든 룸이 청정산소를 공급하는 산소발생기와 독립적인 공기순환시스템이 설치되어 있어 답답함 없이 편안하게 이용하실 수 있습니다.</p>
		</div>

		<div class="guideinfo" style="border-top:1px solid #767676;">
			<h4>운영시간</h4>
			<ul >
				<li><b>365일 무인 운영(09시~21시)</b></li>
				<li>- 웰컴 본인확인 시스템<br>- 원격제어 솔루션 & CCTV관제 시스템</li>
			</ul>
		</div>
			
		<div class="guideinfo">
			<h4>예약 및 사용</h4>
			<ul>
				<li><b>기본예약 시간단위는 1시간이며, 1시간 단위로 이용하실 수 있습니다.</b></li>
				<li><img src="${contextPath}/images/step_img.png"></li>
				<li>※ 이용당일 : 그...스터디카페 도착 > 출입구 비밀번호 입력 > 웰컴 본인확인 > 해당 좌석 또는 스터디룸 이용<br>
					※ 무인 운영으로 출입시 이용자 비밀번호가 필요합니다.</li>
			</ul>
		</div>

		<div class="guideinfo">
			<h4>이용요금</h4>
			<ul>
				<li><b>회원요금(1시간)</b></li>
				<table width="100%" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th>1인석 요금</th>
						<th>다인실 요금</th>
					</tr>
					<tr>
						<td>1,500</td>
						<td>6,000</td>
					</tr>
				</thead>
				</table>
				<li class="part2">(부가세 10%포함, 카드 및 휴대폰 결제 수수료 없음)<br></li>
				<li><b>편의시설 이용안내</b></li>
				<table width="100%" cellpadding="0" cellspacing="0">
				<colgroup>
						<col width="30%">
						<col width="70%">
				</colgroup>
					<tr>
						<th>품목</th>
						<th>가격</th>
					</tr>
					<tr>
						<td class="type01">프린터 이용</td>
						<td>흑백/칼라 100원 (양면 200원)</td>
					</tr>
					<tr>
						<td class="type01">대형모니터<br>※ 스터디룸</td>
						<td>무료</td>
					</tr>
					<tr>
						<td class="type01">노트북 대여</td>
						<td>1시간 1,000원</td>
					</tr>
					<tr>
						<td class="type01">사물함 이용</td>
						<td>당일사용 무료<br>월 사용료 1만원</td>
					</tr>
				</table>
					<li>※ 편의시설 별도사용료는 현장결제만 가능합니다.</li>
					</ul>
			</div>
			<div class="guideinfo">
				<h4>회원종류</h4>
				<ul>
					<li><b>온라인 일반회원 (무료)</b></li>
					<c:if test="${whologin==0 }">
					<li>- 홈페이지에서 간편 회원가입 <a href="<%=NoForm %>meInsert" target="_blank"> [회원가입 바로가기]</a> </li>
					</c:if>
				<table width="100%" cellpadding="0" cellspacing="0">
						<colgroup>
							<col width="110">
							<col width="80">
							<col width="65">
							<col width="65">
							<col width="90">
							<col width="90">
							<col width="90">
							<col width="90">
						</colgroup>
						<tr>
							<th rowspan="2">구분</th>
							<th rowspan="2">가입비</th>
							<th colspan="2">자동실시간 <br>예약 및 변경(24시간)</th>	
							<th rowspan="2">예약현황 및 <br>이용내역조회</th>
							<th colspan="3">결제방법</th>
						</tr>
						<tr>						
							<th>PC</th>
							<th>모바일</th>						
							<th class="type02">계좌이체</th>
							<th class="type02">카드결제</th>
							<th class="type02">현장결제</th>
						</tr>
						<tr>
							<td>온라인<br>일반회원</td>
							<td>무료</td>
							<td>O</td>
							<td>O</td>
							<td>O</td>
							<td>O</td>
							<td>O</td>
							<td>O</td>
						</tr>					
					</table>				
				</ul>
			</div>	
			<div class="guideinfo" style="border-bottom:1px solid #eaeaea;overflow:hidden">
			<div class="common_btn">
			<a href="<%=NoForm%>prList" target="_self">
			 실시간 예약하기 
			</a>
			</div>
		</div>
		</div>
		</div>
	<script type="text/javascript">
	$(document).ready(function({	
	});
	</script>		
</body>
</html>