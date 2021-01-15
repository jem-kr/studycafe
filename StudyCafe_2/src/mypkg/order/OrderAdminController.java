package mypkg.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Order;
import mypkg.common.SuperClass;
import mypkg.dao.OrderDao;

public class OrderAdminController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		
		List<Order>lists = dao.SelectAllOrder();		
		request.setAttribute("lists", lists);
		
		super.doGet(request, response);
		String gotopage="order/orAdmin.jsp";
		super.GotoPage(gotopage);
		
	
	}
}
