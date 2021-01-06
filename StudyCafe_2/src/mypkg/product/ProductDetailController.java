package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductDetailController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_seat = request.getParameter("p_seat");
		
		ProductDao pdao = new ProductDao();
		
		Product bean = pdao.SelectDataByPk(p_seat);
		
		String p_type = bean.getP_type();
		List<Product> glists = pdao.SelectDataByType(p_type);

		
		
		String gotopage = "";
		
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.setAttribute("glists", glists);
			gotopage = "/product/prDetail.jsp";
		}else {
			gotopage = "/product/prList.jsp";
		}
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}
	
}
