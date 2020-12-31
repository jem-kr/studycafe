package mypkg.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductDetailController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		ProductDao pdao = new ProductDao();
		
		Product bean = pdao.SelectDataByPk(pnum);
		
		String gotopage = "";
		
		if (bean != null) {
			request.setAttribute("bean", bean);
			gotopage = "/product/prDetail.jsp";
		}else {
			gotopage = "/product/prList.jsp";
		}
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}
	
}
