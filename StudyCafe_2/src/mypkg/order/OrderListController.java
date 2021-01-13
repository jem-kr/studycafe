package mypkg.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Order;
import mypkg.common.SuperClass;
import mypkg.dao.OrderDao;
import mypkg.dao.ReservationDao;
import mypkg.reservation.ReservationDeleteController;

public class OrderListController extends SuperClass{
	Order bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		bean = new Order();	
		OrderDao odao = new OrderDao();
		bean.setOr_id(request.getParameter("re_id"));
		bean.setOr_etime(Integer.parseInt(request.getParameter("re_etime")));
		bean.setOr_date(String.valueOf(request.getParameter("re_date")));
		bean.setOr_hour(Integer.parseInt(request.getParameter("re_hour")));
		bean.setOr_pday(String.valueOf(request.getParameter("re_pday")));
		bean.setOr_price(Integer.parseInt(request.getParameter("re_price")));
		bean.setOr_rnum(Integer.parseInt(request.getParameter("re_num")));
		bean.setOr_seat(request.getParameter("re_seat"));
		bean.setOr_stime(Integer.parseInt(request.getParameter("re_stime")));

		request.setAttribute("bean", bean);
		
		int cnt = -9999999;
		cnt = odao.InsertData(bean);
		
		new ReservationDeleteController().doGet(request, response);

		String gotopage="order/orList.jsp";
		super.GotoPage(gotopage);
	
	}
	

}
