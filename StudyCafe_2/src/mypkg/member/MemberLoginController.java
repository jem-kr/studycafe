package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
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

		this.id = request.getParameter("id");
		this.password = request.getParameter("password");

		String gotopage = "";

		super.doPost(request, response);

		if (this.validate(request) == false) {
			// 유효성 검사 통과 못함.

			request.setAttribute("id", id);
			request.setAttribute("password", password);

			gotopage = "member/meLoginForm.jsp";
			super.GotoPage(gotopage);

		} else {
			// 유효성 검사 통과
			// 데이터 베이스에서 해당 id 와 비밀번호가 일치하는지 찾음
			MemberDao dao = new MemberDao();
			Member bean = dao.SelectByPk(id, password);

			if (bean != null) {
				// id와 pw 발견
				super.session.setAttribute("loginfo", bean);

				gotopage = "main/main.jsp";
				super.GotoPage(gotopage);

			} else {
				// 해당 id와 pw 를 찾을 수 없음
				
				String err_message = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.";
				
				request.setAttribute("err_message", err_message);
				
				gotopage = "member/meLoginForm.jsp";
				super.GotoPage(gotopage);

			}

		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		// 로그인 유효성 검사 체크
		boolean isCheck = true;

		// case 3가지로 나뉨
		// 1) id와 pw 둘다 미입력 : "아이디를 입력해주세요."
		// 2) id 입력 , pw 미입력 : "비밀번호를 입력해주세요." , 입력한 id는 남아있게 함
		// 3) id 미입력 , pw 입력 : "아이디를 입력해주세요." , 입력한 pw는 남아있게 함

		// case 1)
		if (this.id.length() == 0 && this.password.length() == 0) {
			request.setAttribute(super.PREFIX + "id", "아이디를 입력해주세요.");
			isCheck = false;
		}

		// case 2)
		if (this.id.length() > 0 && this.password.length() == 0) {
			request.setAttribute(super.PREFIX + "password", "비밀번호를 입력해주세요.");
			isCheck = false;
		}

		// case 3)
		if (this.id.length() == 0 && this.password.length() > 0) {
			request.setAttribute(super.PREFIX + "id", "아이디를 입력해주세요.");
			isCheck = false;
		}

		return isCheck;// 기본값
	}
}

