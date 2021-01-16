package mypkg.reservation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.bean.Order;
import mypkg.bean.Product;
import mypkg.bean.Reservation;
import mypkg.common.SuperClass;
import mypkg.dao.OrderDao;
import mypkg.dao.ProductDao;
import mypkg.dao.ReservationDao;
import mypkg.product.ProductDetailController;

public class ReservationInsertController extends SuperClass{
	Reservation bean = null;
	Product pbean = null;
	ProductDao pdao = null;
	OrderDao odao = null;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pdao = new ProductDao();
		pbean= new Product();
		pbean.setP_date(request.getParameter("p_date"));
		pbean.setP_etime(Integer.parseInt(request.getParameter("p_etime")));
		if(request.getParameter("p_hour")==null||request.getParameter("p_hour")==""){
			pbean.setP_hour(0);
		}else {
			pbean.setP_hour(Integer.parseInt(request.getParameter("p_hour")));
		}
		
//		pbean.setP_price(Integer.parseInt(request.getParameter("p_price")));
		pbean.setP_seat(request.getParameter("p_seat"));
		pbean.setP_stime(Integer.parseInt(request.getParameter("p_stime")));
		pbean.setP_type(request.getParameter("p_type"));
		if(pbean.getP_type().equals("다인실")) {
			pbean.setP_price(6000);
		}else {
			pbean.setP_price(1500);
		}
		System.out.println(pbean.getP_seat());
		if (this.validate(request)==false) {
			if (pbean != null) {
				request.setAttribute("bean", pbean);
				
				String p_type = pbean.getP_type();
				
				List<Product> glists = pdao.SelectDataByType(p_type);
				request.setAttribute("glists", glists);}
				
			
			super.doPost(request, response);
			
			String gotopage = "product/prDetail.jsp";
			super.GotoPage(gotopage);
			
		} else {
			super.doPost(request, response);
			odao = new OrderDao();
			int check = -999999;
			check = odao.checkduplicate(pbean.getP_seat(), pbean.getP_date(), pbean.getP_stime(), pbean.getP_etime());
			if(check == 0 ) {
			
			bean = new Reservation();
			ReservationDao rdao = new ReservationDao();
			Member loginfo = (Member)super.session.getAttribute("loginfo") ;
			bean.setRe_date(pbean.getP_date());
			bean.setRe_etime(pbean.getP_etime());
			bean.setRe_hour(pbean.getP_hour());
			bean.setRe_id(loginfo.getId());
			
//			int person =1;
//			if(request.getParameter("p_person")!=null) {
			bean.setRe_person(Integer.parseInt(request.getParameter("p_person")));
//			}else {
//				bean.setRe_person(person);
//			}
			bean.setRe_price(pbean.getP_hour()*pbean.getP_price());
			
			bean.setRe_seat(pbean.getP_seat());
			bean.setRe_stime(pbean.getP_stime());
			bean.setRe_type(pbean.getP_type());
			bean.setRemark(pbean.getRemark());
			
			String gotopage="";
			request.setAttribute("bean", bean);
			int cnt = -999999;
			
			// 예약 테이블 insert 처리 
			cnt = rdao.InsertData(bean);
			
			bean = null;
			
			bean = rdao.SelectDataById(loginfo.getId());
			gotopage="reservation/reInsert.jsp";
			super.GotoPage(gotopage);
			}
			else {
				session.setAttribute("message", "예약이 불가한 시간입니다.");
				String gotopage = "product/prDetail.jsp";
				super.GotoPage(gotopage);
			}
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		SimpleDateFormat format1 = new SimpleDateFormat("YYYYMMDD"); // 현재 년 월 일
		SimpleDateFormat format2 = new SimpleDateFormat("HH");
		Date date = new Date();
		String today="";
		String hh = "";

		if( pbean.getP_seat().equals("-") ){
			request.setAttribute( super.PREFIX + "p_seat", "좌석 번호는 필수 입력 사항입니다.");
			isCheck = false  ;
		}			
		
		if( pbean.getP_date() == null || pbean.getP_date()==""){
			request.setAttribute( super.PREFIX + "p_date", "예약 일자를 지정해주세요.");
			isCheck = false  ;
		}
		
		
		if( Integer.parseInt(request.getParameter("p_person")) == 0){
			request.setAttribute( super.PREFIX + "p_person", "이용인원을 선택해주세요.");
			isCheck = false  ;
		}
		// p_date는 오늘과 같거나 커야하고 시작시간은 지금 시간 보다 커야함
		// 시작 시간
		// 오늘 날짜 & 현재 시간 이후
		
		String temp = pbean.getP_date() ;
		String _temp = temp.replace("/", "");
		int aaa =0;
		if(_temp == null || _temp.equals("")) {
			request.setAttribute( super.PREFIX + "p_date", "예약 일자를 지정해주세요.");
			isCheck = false  ;
		}else {
		aaa = Integer.parseInt(_temp);
		System.out.println(aaa);
		}
		
		today = format1.format(date); // 문자열
		int now = Integer.parseInt(today);
		System.out.println(now);
		
		int stime = pbean.getP_stime();
		hh = format2.format(date);
		int HH = Integer.parseInt(hh);
		if (aaa==now && stime <= HH) {
			request.setAttribute( super.PREFIX + "p_stime", "시작 시간은 현재 시간 이후로 선택해 주세요." );
			isCheck = false;
		}

		// 종료 시간
		// 시작 시간 이후
		if (pbean.getP_etime() < pbean.getP_stime()) {
			request.setAttribute( super.PREFIX + "p_etime", "종료 시간은 시작 시간 이후로 선택해 주세요." );
			isCheck = false;
		}

		if( pbean.getP_hour() <= 0 ) {
			request.setAttribute( super.PREFIX + "p_hour", "시작 및 종료 시간을 다시 설정해 주세요.");
			isCheck = false  ;
		}			
		
		if( pbean.getP_price() <= 0 ) {
			request.setAttribute( super.PREFIX + "p_price", "가격을 다시 한번 확인해 주세요.");
			isCheck = false  ;
		}		
		
		return isCheck;
	}
}
