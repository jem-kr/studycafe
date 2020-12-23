package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberLoginController extends SuperClass {
	String id = null;
	String password = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String gotopage = "member/meLoginForm.jsp";
		response.sendRedirect(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.id = request.getParameter("id");
		this.password = request.getParameter("password");

		MemberDao dao = new MemberDao();
		Member bean = null;

		HttpSession session = request.getSession();

		String gotopage = "";
		if (this.validate(request) == false) {
			// 유효성 검사 통과 못함
			gotopage = "/member/meLoginForm.jsp";
			super.GotoPage(gotopage);

		} else {
			// 유효성 검사 통과함
			// 해당 id와 password 가 존재하는지 db에서 조회함.
			bean = dao.SelectByPk(id, password);
			
			if (bean != null) {//db 발견
				session.setAttribute("loginfo", bean);
				gotopage = "main/main.jsp";
				super.GotoPage(gotopage);
				
				System.out.println("로그인 성공");
			} else {//db 발견 x 
				System.out.println("로그인 실패");
				
				String message = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.";
				super.setErrorMessage(message);
				
				gotopage = "member/meLoginForm.jsp";
				super.GotoPage(gotopage);
			}
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		// 로그인 유효성 검사 체크
		boolean isCheck = true;

		// id 입력을 안했을 때
		if (this.id.length() < 0) {
			request.setAttribute(super.PREFIX + "id", "아이디를 입력해주세요.");
			isCheck = false;
		}

		// 비밀번호를 입력을 안했을 때
		if (this.password.length() < 0 ) {
			request.setAttribute(super.PREFIX + "password", "비밀번호를 입력해주세요.");
			isCheck = false;
		}

		return isCheck;// 기본값
	}
}

//회원가입 시 사용 할 것
//// id : 영문 대문자 or 소문자 or 숫자로 시작 하고 , 길이는 4~15글자 , 끝날 때 영문 대문자 또는 소문자 또는 숫자
//String regex = " /^[A-Za-z0-9]{4,15}$/g";
//boolean id_result = Pattern.matches(regex, this.id);
//if (id_result == false) {
//	request.setAttribute(super.PREFIX + "id", "4 ~ 15자 영문 대 소문자, 숫자를 사용하세요.");
//	isCheck = false;
//}

//회원가입 시 사용 할 것
//pw : 영문 대문자 or 소문자 or 숫자로 시작 하고 , 길이는 4~15글자 , 끝날 때 영문 대문자 또는 소문자 또는 숫자
