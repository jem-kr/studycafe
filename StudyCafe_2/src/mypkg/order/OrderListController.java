package mypkg.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.bean.Order;
import mypkg.bean.Reservation;
import mypkg.common.SuperClass;
import mypkg.dao.OrderDao;
import mypkg.dao.ReservationDao;
import mypkg.reservation.ReservationDeleteController;

public class OrderListController extends SuperClass{
	Order bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		Member mem = (Member) super.session.getAttribute("loginfo");
		bean = new Order();	
		ReservationDao rdao = new ReservationDao();
		OrderDao odao = new OrderDao();
		Reservation res = rdao.SelectDataById(mem.getId());
		
		
		bean.setOr_id(res.getRe_id());
		bean.setOr_etime(res.getRe_etime());
		bean.setOr_date(res.getRe_date());
		bean.setOr_hour(res.getRe_hour());
		bean.setOr_pday(res.getRe_pday());
		bean.setOr_price(res.getRe_price());
		bean.setOr_rnum(res.getRe_no());
		bean.setOr_seat(res.getRe_seat());
		bean.setOr_stime(res.getRe_stime());

		request.setAttribute("bean", bean);
		
		int cnt = -9999999;
		cnt = odao.InsertData(bean);
		
		

		String gotopage="order/orList.jsp";
		super.GotoPage(gotopage);
		
		new ReservationDeleteController().doGet(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
	
	}
	

}
