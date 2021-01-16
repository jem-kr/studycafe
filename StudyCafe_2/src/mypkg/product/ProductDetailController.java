package mypkg.product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;

public class ProductDetailController extends SuperClass {
	public Product bean = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_seat = request.getParameter("p_seat");

		ProductDao pdao = new ProductDao();

		bean = pdao.SelectDataByPk(p_seat);

		String gotopage = "";

		super.doGet(request, response);
		if (bean != null) {
			request.setAttribute("bean", bean);
			
			String p_type = bean.getP_type();
			
			List<Product> glists = pdao.SelectDataByType(p_type);
			request.setAttribute("glists", glists);
			
			System.out.println(p_seat);
			
			gotopage = "product/prDetail.jsp";
		} else {
			gotopage = "product/prList.jsp";
		}
		
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		bean = new Product();

		bean.setP_pic(multi.getFilesystemName("p_pic"));
		String gotopage = "";
		if (this.validate(request) == true) {
			ProductDao pdao = new ProductDao();

			int cnt = -99999;

			// Bean객체를 이용해 해당 게시물 추가됨
			cnt = pdao.InsertData(bean);
			// 목록보기로 리다이렉션
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

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true; //
		
		SimpleDateFormat format1 = new SimpleDateFormat("YYYY/MM/DD");
		SimpleDateFormat format2 = new SimpleDateFormat("HH");

//		orders의 or_seat과 products의 p_seat이 같으면,
//		prDetail에서 보이지 않음		
//		if(bean.getP_seat().equalsIgnoreCase(bean.getOr_seat()){
//			request.setAttribute( super.PREFIX + "name", "해당 좌석은 선택할 수 없습니다.");
//			isCheck = false  ;
//		}
		
		// 선택에서 null이나 0이 있으면 넘어가지 못함

		if( bean.getP_seat() == null || bean.getP_seat() == "" ){
			request.setAttribute( super.PREFIX + "p_seat", "좌석 번호는 필수 입력 사항입니다.");
			isCheck = false  ;
		}			
		
		String regex = "\\d{4}[/]\\d{2}[/]\\d{2}";
		if( bean.getP_date() == null){
			bean.setP_date( "" );
		}
		boolean result = Pattern.matches(regex, bean.getP_date());
		if (result == false ) {
			request.setAttribute( super.PREFIX + "p_date", "입고 일자는 yyyy/MM/dd 형식으로 입력해 주세요.");
			isCheck = false  ;
		}
		
		
		// p_date는 오늘과 같거나 커야하고 시작시간은 지금 시간 보다 커야함
		// 시작 시간
		// 오늘 날짜 & 현재 시간 이후
		if (bean.getP_date() == "format1" && bean.getP_stime() < Integer.parseInt("format2")) {
			request.setAttribute( super.PREFIX + "p_stime", "시작 시간은 현재 시간 이후로 선택해 주세요." );
			isCheck = false;
		}

		// 종료 시간
		// 시작 시간 이후
		if (bean.getP_etime() < bean.getP_stime()) {
			request.setAttribute( super.PREFIX + "p_etime", "종료 시간은 시작 시간 이후로 선택해 주세요." );
			isCheck = false;
		}

		if( bean.getP_hour() <= 0 ) {
			request.setAttribute( super.PREFIX + "p_hour", "시작 및 종료 시간을 다시 설정해 주세요.");
			isCheck = false  ;
		}			
		
		if( bean.getP_price() <= 0 ) {
			request.setAttribute( super.PREFIX + "p_price", "가격을 다시 한번 확인해 주세요.");
			isCheck = false  ;
		}		
		

		return isCheck;
	}

}
