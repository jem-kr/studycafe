package mypkg.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductUpdateController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_seat = request.getParameter("p_seat");
		
		ProductDao pdao = new ProductDao();
		Product bean = pdao.SelectDataByPk(p_seat);
		
		request.setAttribute("bean", bean);
		String gotopage = null;
		gotopage = "product/prUpdate.jsp";
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}
	
	private Product bean = null ;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
		
		bean = new Product();

		bean.setP_type(multi.getParameter("p_type"));
		
		bean.setP_seat(multi.getParameter("p_seat"));
				
		bean.setP_date(multi.getParameter("p_date"));
		
		if(multi.getParameter("p_stime")!=null && multi.getParameter("p_stime").equals("")==false) {
		bean.setP_stime(Integer.parseInt(multi.getParameter("p_stime")));
		}			
		
		if(multi.getParameter("p_etime")!=null && multi.getParameter("p_etime").equals("")==false) {
		bean.setP_etime(Integer.parseInt(multi.getParameter("p_etime")));
		}
		
		if(multi.getParameter("p_hour")!=null && multi.getParameter("p_hour").equals("")==false) {
		bean.setP_hour(Integer.parseInt(multi.getParameter("p_hour")));
		}		
		
		if(multi.getParameter("p_price")!=null && multi.getParameter("p_price").equals("")==false) {
		bean.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		}		
		
		bean.setP_pic(multi.getFilesystemName("p_pic"));
	
		System.out.println( bean );		
	 
		String gotopage = "";
		if ( this.validate( request ) == false ) {
			System.out.println("수정 유효성검사 실패");			  
			request.setAttribute("bean", bean);
			gotopage = "product/prUpdate.jsp" ;
			super.doPost(request, response);
			super.GotoPage( gotopage );		
		}else{
			ProductDao pdao = new ProductDao();			
			int cnt = -999999 ; 			
			cnt = pdao.UpdateData(bean) ;
			System.out.println(cnt);
			session.setAttribute("message", "좌석 정보가 수정되었습니다!");
			new ProductListController().doGet(request, response);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ; //기본 값으로 true
		
		if( bean.getP_type().length() < 1){
			request.setAttribute( super.PREFIX + "p_type", "상품 이름은 최소 1글자 이상");
			isCheck = false  ;
		}
		
		if( bean.getP_seat().length() < 1){
			request.setAttribute( super.PREFIX + "p_seat", "좌석 번호는 최소 1글자 이상");
			isCheck = false  ;
		}
		
		if( bean.getP_price() < 1500 || bean.getP_price() > 100000 ){
			request.setAttribute( super.PREFIX + "p_price", "가격은 최소 1,500원 이상, 100,000원 이하");
			isCheck = false  ;
		}		

		if( bean.getP_pic() == null || bean.getP_pic() == "" ){
			request.setAttribute( super.PREFIX + "p_pic", "이미지는 필수 입력 사항입니다.");
			isCheck = false  ;
		}
		
		return isCheck ;
		
	}

}
