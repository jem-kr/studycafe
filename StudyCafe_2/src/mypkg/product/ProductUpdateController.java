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
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		ProductDao pdao = new ProductDao();
		Product bean = pdao.SelectDataByPk(pnum);
		
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
		bean.setPnum(Integer.parseInt(multi.getParameter("pnum")));
		bean.setCategory( multi.getParameter("category"));		
		bean.setPtype( multi.getParameter("ptype"));
		bean.setItem( multi.getParameter("item"));
		bean.setSeatnum( multi.getParameter("seatnum"));		
		bean.setHours(Integer.parseInt(multi.getParameter("hours")));
		bean.setPrice(Integer.parseInt(multi.getParameter("price")));
		bean.setPic( multi.getFilesystemName("pic") );
		
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
			new ProductListController().doGet(request, response);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ; //기본 값으로 true
		
		if( bean.getItem().length() < 3 || bean.getItem().length() > 10 ){
			request.setAttribute( super.PREFIX + "item", "상품 이름은 3글자 이상 10글자 이하");
			isCheck = false  ;
		}
		
		if( bean.getCategory().length() < 1 || bean.getCategory().length() > 10 ){
			request.setAttribute( super.PREFIX + "category", "상품 카테고리는 1글자 이상 10글자 이하");
			isCheck = false  ;
		}
		
		if( bean.getSeatnum().length() < 1 || bean.getSeatnum().length() > 8 ){
			request.setAttribute( super.PREFIX + "seatnum", "좌석번호는 1글자 이상 8글자 이하");
			isCheck = false  ;
		}
		
		if( bean.getPtype().length() < 1 || bean.getPtype().length() > 8 ){
			request.setAttribute( super.PREFIX + "ptype", "좌석유형는 1글자 이상 8글자 이하");
			isCheck = false  ;
		}
		
		if( bean.getHours() < 1 || bean.getHours() > 24 ){
			request.setAttribute( super.PREFIX + "hours", "시간은 최소 1시간 이상, 24시간 이하");
			isCheck = false  ;
		}

		
		if( bean.getPrice() < 1500 || bean.getPrice() > 100000){
			request.setAttribute( super.PREFIX + "price", "가격은 최소 1,500원 이상, 100,000원 이하");
			isCheck = false  ;
		}
		
		if( bean.getPic() == null || bean.getPic() == "" ){
			request.setAttribute( super.PREFIX + "pic", "이미지는 필수 입력 사항입니다.");
			isCheck = false  ;
		}		
		
		return isCheck ;
		
	}

}
