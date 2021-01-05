package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberIdSearchController extends SuperClass {
	String name = "";
	String phone = "";
	String gotopage = "";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		super.doGet(request, response);

		this.gotopage = "member/meIdSearch.jsp";

		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		this.name = request.getParameter("name");
		this.phone = request.getParameter("phone");

		super.doPost(request, response);
		
		if (this.validate(request) == true) {
			// 유효성 검사 통과
			MemberDao dao = new MemberDao();
			Member bean = dao.IdSearchData(this.name , this.phone);
			
			request.setAttribute("isCheck", true);
			if (bean != null) { 
				// 해당하는 id가 존재 
				request.setAttribute("id_find", bean.getId());
				request.setAttribute("id_findmsg", "고객님의 정보와 일치하는 아이디입니다.");
				
				this.gotopage = "member/meIdSearch.jsp";

				super.GotoPage(gotopage);
			}else {
				// 해당하는 id가 존재하지않음
				request.setAttribute("id_findmsg", "고객님의 정보와 일치하는 아이디가 존재하지 않습니다.");
				
				this.gotopage = "member/meIdSearch.jsp";

				super.GotoPage(gotopage);
			}
		}else {
			// 유효성 검사 실패
			request.setAttribute("name", this.name);
			request.setAttribute("phone", this.phone);
			
			this.gotopage = "member/meIdSearch.jsp";
			super.GotoPage(gotopage);
			
		}
	}

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		String regex = "";
		
		// 이름
		regex = "^[가-힣a-zA-Z]*$";
		boolean name_result = Pattern.matches(regex, this.name);
		if (name_result == false) {
			request.setAttribute(super.PREFIX+"name", "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
			isCheck = false;
		}
		
		if (this.name.length() == 0) {
			request.setAttribute(super.PREFIX+"name", "이름을 입력하세요.");
			isCheck = false;
		}
		
		// 휴대폰 번호
		regex = "^[0-9]{10,11}$";
		boolean phone_result = Pattern.matches(regex, this.phone);
		if (phone_result == false) {
			request.setAttribute(super.PREFIX+"phone", "숫자 10 ~ 11자만 사용이 가능합니다.( - 하이픈 , 공백 사용 불가)");
			isCheck = false;
		}
		if (this.phone.startsWith("0") == false) {
			request.setAttribute(super.PREFIX+"phone", "올바른 휴대폰 번호 형식이 아닙니다.");
			isCheck = false;
		}
		if (this.phone.length() == 0) {
			request.setAttribute(super.PREFIX+"phone", "휴대폰 번호를 입력하세요.");
			isCheck = false;
		}
		
		

		return isCheck;
	}

}
