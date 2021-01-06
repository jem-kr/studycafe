package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductListController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		
		List<Product> lists = dao.SelectDataList();

		
		request.setAttribute("lists", lists);

		
		super.doGet(request, response);
		String gotopage = "product/prList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
}