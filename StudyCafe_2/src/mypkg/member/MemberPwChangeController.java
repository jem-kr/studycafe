package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberPwChangeController extends SuperClass {
	String id = "";
	String new_pw = "";
	String new_pwCheck = "";
	String gotopage = "";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		this.id = request.getParameter("id");
		this.new_pw = request.getParameter("new_pw");
		this.new_pwCheck = request.getParameter("new_pwCheck");

		// System.out.println("id ===> " + this.id);

		super.doPost(request, response);

		if (this.validate(request) == true) {
			// 유효성 검사 통과
			System.out.println("유효성 검사 통과");

			int cnt = -1;
			MemberDao dao = new MemberDao();

			cnt = dao.UpdatePassword(this.id, this.new_pw);
			
			if (cnt > 0) {
				System.out.println("비밀번호 업데이트 성공");
			} else {
				System.out.println("비밀번호 업데이트 실패");
			}
			this.gotopage = "member/meLoginForm.jsp";
			session.setAttribute("message", "비밀번호가 변경되었습니다. 더 많은 정보를 보려면 로그인을 해주세요.");
			super.GotoPage(gotopage);
			
		} else {
			// 유효성 검사 통과 못함
			request.setAttribute("id", this.id);
			request.setAttribute("new_pw", this.new_pw);
			request.setAttribute("new_pwCheck", this.new_pwCheck);

			this.gotopage = "member/mePwChange.jsp";
			super.GotoPage(gotopage);
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;

		String regex = "";

		// 새비밀번호
		regex = "^[a-zA-Z0-9]{5,15}$";
		boolean new_pw_result = Pattern.matches(regex, this.new_pw);
		if (new_pw_result == false) {
			request.setAttribute(super.PREFIX + "newpassword", "5 ~ 15글자의 영문 대 소문자, 숫자만 사용이 가능합니다.");
			isCheck = false;
		}

		if (this.new_pw.length() == 0) {
			request.setAttribute(super.PREFIX + "newpassword", "새 비밀번호를 입력하세요.");
			isCheck = false;
		}

		// 새비밀번호 확인
		if (this.new_pw.equals(this.new_pwCheck) == false) {
			request.setAttribute(super.PREFIX + "newpassword_ck", "새 비밀번호가 일치하지 않습니다.");
			isCheck = false;
		}

		if (this.new_pwCheck.length() == 0) {
			request.setAttribute(super.PREFIX + "newpassword_ck", "새 비밀번호를 입력하세요.");
			isCheck = false;
		}

		return isCheck;
	}
}
