package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;
import mypkg.reservation.ReservationDeleteController;

public class AdminSeatController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		
		List<Product> lists = dao.SelectDataList();

		
		request.setAttribute("lists", lists);
		
		super.doGet(request, response);
		
		Member loginfo = (Member)super.session.getAttribute("loginfo");
		if(loginfo!=null) {
		new ReservationDeleteController().doGet(request, response);
		}
		String gotopage = "product/adminSeat.jsp" ;
		super.GotoPage(gotopage);

		
	}
	
	
}