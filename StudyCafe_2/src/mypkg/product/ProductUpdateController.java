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
		
		bean  = new Product();
		bean.setP_type( multi.getParameter("p_type"));		
		bean.setP_seat( multi.getParameter("p_seat"));
		bean.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		bean.setP_pic( multi.getFilesystemName("p_pic"));		
		
//		if( multi.getParameter("pnum") != null && multi.getParameter("pnum").equals("") == false){
//			bean.setPnum( Integer.parseInt( multi.getParameter("pnum") ));	
//		}
//		if( multi.getParameter("hours") != null && multi.getParameter("hours").equals("") == false){
//			bean.setHours( Integer.parseInt( multi.getParameter("hours") ));	
//		}
//		if( multi.getParameter("price") != null && multi.getParameter("price").equals("") == false){
//			bean.setPrice( Integer.parseInt( multi.getParameter("price") ));	
//		}
	
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
			new ProductUpdateController().doGet(request, response);
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
