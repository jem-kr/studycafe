package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductDetailController extends SuperClass {
	private Product bean = null;

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

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		bean = new Product();
		
		bean.setP_pic(multi.getFilesystemName("p_pic"));
		String gotopage = "";
		if(this.validate(request) == true) {
			ProductDao pdao = new ProductDao();
			
			int cnt = -99999;
			
			//Bean객체를 이용해 해당 게시물 추가됨
			cnt = pdao.InsertData(bean);
			//목록보기로 리다이렉션
			new ProductDetailController().doGet(request, response);
			System.out.println("이미지 파일 업로드");
		} else {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "product/prDetail.jsp";
			super.GotoPage(gotopage);
			System.out.println("else 이미지 파일 업로드");

		}
		
	}
	
}
