package mypkg.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;
import mypkg.utility.FlowParameters;

public class ProductDeleteController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_seat = request.getParameter("p_seat");

		ProductDao dao = new ProductDao();
		
		int cnt = -999999 ;
		cnt = dao.DeleteData(p_seat) ;
		
		new ProductListController().doGet(request, response); 				
	}	
}
