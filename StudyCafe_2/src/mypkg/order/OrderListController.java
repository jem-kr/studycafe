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

public class OrderListController extends SuperClass {
	Order bean = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("re_id");

		ReservationDao rdao = new ReservationDao();

		Reservation re_bean = rdao.SelectDataById(id);

		super.doGet(request, response);
		
		if (re_bean != null) {
			// id에 해당하는 예약 내역이 발견
			this.bean = new Order();

			this.bean.setOr_id(re_bean.getRe_id());
			this.bean.setOr_etime(re_bean.getRe_etime());
			this.bean.setOr_date(re_bean.getRe_date());
			this.bean.setOr_hour(re_bean.getRe_hour());
			this.bean.setOr_pday(re_bean.getRe_pday());
			this.bean.setOr_price(re_bean.getRe_price());
			this.bean.setOr_rnum(re_bean.getRe_no());

			// System.out.println("좌석번호 ===> " + re_bean.getRe_seat());

			this.bean.setOr_seat(re_bean.getRe_seat());
			this.bean.setOr_stime(re_bean.getRe_stime());

			int cnt = -9999999;

			OrderDao dao = new OrderDao();
			cnt = dao.InsertData(bean);

			if (cnt > 0) {
				// orders 테이블에 insert 성공
				request.setAttribute("bean", this.bean);
				String gotopage = "order/orList.jsp";
				super.GotoPage(gotopage);
			}
		}

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);

	}

}
