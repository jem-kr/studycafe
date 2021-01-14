package mypkg.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.bean.Reservation;
import mypkg.common.SuperClass;
import mypkg.dao.ReservationDao;

public class ReservationInsertController extends SuperClass{
	Reservation bean = null;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		bean = new Reservation();
		ReservationDao rdao = new ReservationDao();
		Member loginfo = (Member)super.session.getAttribute("loginfo") ;
		bean.setRe_date(request.getParameter("p_date"));
		bean.setRe_etime(Integer.parseInt(request.getParameter("p_etime")));
		bean.setRe_hour(Integer.parseInt(request.getParameter("p_hour")));
		bean.setRe_id(loginfo.getId());
		
		int person =1;
		if(request.getParameter("p_person")!=null) {
		bean.setRe_person(Integer.parseInt(request.getParameter("p_person")));
		}else {
			bean.setRe_person(person);
		}
		bean.setRe_price(Integer.parseInt(request.getParameter("p_price")));
		bean.setRe_seat(request.getParameter("p_seat"));
		bean.setRe_stime(Integer.parseInt(request.getParameter("p_stime")));
		bean.setRe_type(request.getParameter("p_type"));
		bean.setRemark(request.getParameter("remark"));
		
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
	
	@Override
	public boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(request);
	}
}
