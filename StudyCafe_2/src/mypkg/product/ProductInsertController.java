package mypkg.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;


public class ProductInsertController  extends SuperClass{
	private Product bean = null;
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ; //기본 값으로 true
		
		if( bean.getItem().length() < 3 || bean.getItem().length() > 10 ){
			request.setAttribute( super.PREFIX + "item", "상품 이름은 3자리 이상 10자리 이하");
			isCheck = false  ;
		}
		
		if( bean.getSeatnum().length() < 1 || bean.getSeatnum().length() > 8 ){
			request.setAttribute( super.PREFIX + "seatnum", "좌석번호는 1자리 이상 8자리 이하");
			isCheck = false  ;
		}
		
		if( bean.getPtype().length() < 1 || bean.getPtype().length() > 8 ){
			request.setAttribute( super.PREFIX + "ptype", "좌석유형는 1자리 이상 8자리 이하");
			isCheck = false  ;
		}
		
		if( bean.getPrice() < 1500 || bean.getPrice() > 10000 ){
			request.setAttribute( super.PREFIX + "price", "가격은 최소 1500원 이상, 10000원 이하");
			isCheck = false  ;
		}
		
		if( bean.getHours() < 1 || bean.getHours() > 24 ){
			request.setAttribute( super.PREFIX + "hours", "시간은 최소 1시간 이상, 24시간 이하");
			isCheck = false  ;
		}
		
		if( bean.getCategory().length() < 1 || bean.getCategory().length() > 10 ){
			request.setAttribute( super.PREFIX + "category", "카테고리는 최소 1자리 이상 10자리 이하");
			isCheck = false  ;
		}
		
		if( bean.getPic() == null || bean.getPic() == "" ){
			request.setAttribute( super.PREFIX + "pic", "이미지는 필수 입력 사항입니다.");
			isCheck = false  ;
		}		
		
		return isCheck ;
		
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String url = "product/prInsert.jsp";
		super.GotoPage(url);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		
		//상품번호 pnum은 시퀀스 처리.
		bean = new Product();
		System.out.println("[" + multi.getParameter("category") + "]");
		if(multi.getParameter("hours") != null
				&& multi.getParameter("hours").equals("") == false) {
			bean.setHours(Integer.parseInt(multi.getParameter("hours")));
		}
		if(multi.getParameter("price") != null
				&& multi.getParameter("price").equals("") == false) {
			bean.setPrice(Integer.parseInt(multi.getParameter("price")));
		}
		
		bean.setCategory(multi.getParameter("category"));
		bean.setItem(multi.getParameter("item"));
		bean.setPic(multi.getFilesystemName("pic"));
		bean.setPtype(multi.getParameter("ptype"));
		bean.setSeatnum(multi.getParameter("seatnum"));
		
		String gotopage = "";
		if(this.validate(request) == true) {
			ProductDao pdao = new ProductDao();
			
			int cnt = -99999;
			
			//Bean객체를 이용해 해당 게시물 추가됨
			cnt = pdao.InsertData(bean);
			//목록보기로 리다이렉션
			new ProductListController().doGet(request, response);
			System.out.println("이미지 파일 업로드");
		} else {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "product/prInsert.jsp";
			super.GotoPage(gotopage);
			System.out.println("else이미지 파일 업로드");

		}
	}
}
