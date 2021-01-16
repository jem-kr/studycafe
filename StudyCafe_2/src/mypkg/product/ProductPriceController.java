package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Price;
import mypkg.common.SuperClass;
import mypkg.dao.PriceDao;

public class ProductPriceController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PriceDao dao = new PriceDao();
		
		List<Price> lists = dao.prPrice();
		
		request.setAttribute("lists", lists);
		
		String gotopage = "product/prPrice.jsp";
		
		super.GotoPage(gotopage);
		
	}
	
}
