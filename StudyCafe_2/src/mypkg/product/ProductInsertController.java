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
		// 관리자가 좌석 등록 시 유효성검사
		boolean isCheck = true ;
		
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
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String url = "product/prInsert.jsp";
		super.GotoPage(url);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		
		// 상품 bean
		bean = new Product();

		// 좌석 유형
		bean.setP_type(multi.getParameter("p_type"));
		
		// 좌석 이름
		bean.setP_seat(multi.getParameter("p_seat"));
		
		// 좌석 이용가격
		if(multi.getParameter("p_price")!=null && multi.getParameter("p_price").equals("")==false) {
		bean.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		}		
		
		// 상품 예약날짜 및 시간은 실제 좌석 등록 시 관리자에게 필요하지 않지만,
		// 테스트 등 필요한 경우를 고려하여 추가해 놓았습니다. (p_date, p_stime, p_etime, p_hour)
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
		
		// 좌석 이미지
		bean.setP_pic(multi.getFilesystemName("p_pic"));
		
		String gotopage = "";
		if(this.validate(request) == true) {
			ProductDao pdao = new ProductDao();
			
			int cnt = -99999;
			
			// Bean객체를 이용해 해당 게시물 추가됩니다.
			cnt = pdao.InsertData(bean);
			
			// 좌석 목록 보기로 리다이렉션됩니다.
			new ProductListController().doGet(request, response);
			System.out.println("이미지 파일 업로드");
			
		} else {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage = "product/prInsert.jsp";
			super.GotoPage(gotopage);
			System.out.println("else 이미지 파일 업로드");

		}
	}
}
