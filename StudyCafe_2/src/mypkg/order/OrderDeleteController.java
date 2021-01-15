package mypkg.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.OrderDao;

public class OrderDeleteController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int or_no = Integer.parseInt(request.getParameter("or_no"));
		OrderDao odao = new OrderDao();
		int cnt = -9999999;
		cnt = odao.DeleteDate(or_no);
		
		super.doGet(request, response);
		
		String gotopage="main/main.jsp";
		super.GotoPage(gotopage);
	}
	
	
}
