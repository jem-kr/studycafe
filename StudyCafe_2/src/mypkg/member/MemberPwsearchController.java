package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberPwsearchController extends SuperClass {
	String gotopage = "";
	String id = "";
	String phone = "";
	String pwanswer = "";
	Member bean = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		super.doGet(request, response);

		this.gotopage = "member/mePwSearch.jsp";

		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		this.pwanswer = request.getParameter("pwanswer");

		if (this.pwanswer == null) {// 비밀번호 찾기 답변을 입력받기 전
			System.out.println("비밀번호 입력 답변 : " + this.pwanswer);

			// 아이디와 휴대폰 번호는 가장 먼저 입력받는 파라미터 값들이다.
			this.id = request.getParameter("id");// 아이디
			this.phone = request.getParameter("phone");// 휴대폰 번호

			super.doPost(request, response);

			// id와 phone 번호로 비밀번호 질문 찾기
			if (this.validate(request) == true) {
				// 유효성 검사 통과

				MemberDao dao = new MemberDao();

				this.bean = dao.SelectDataPwquestion(this.id, this.phone);

				if (this.bean != null) {
					// 해당 질문을 찾음
					request.setAttribute("bean", bean);
					request.setAttribute("id", bean.getId());
					request.setAttribute("phone", bean.getPhone());
					this.gotopage = "member/mePwSearch.jsp";
					super.GotoPage(gotopage);

				} else {
					// 해당 질문을 못찾음
					String imsi = "고객님의 정보와 일치하는 아이디가 존재하지 않습니다.";
					request.setAttribute(super.PREFIX + "password", imsi);
					this.gotopage = "member/mePwSearch.jsp";
					super.GotoPage(gotopage);
				}

			} else {
				// 유효성 검사 통과 X

				request.setAttribute("id", this.id);
				request.setAttribute("phone", this.phone);

				this.gotopage = "member/mePwSearch.jsp";
				super.GotoPage(gotopage);

			}

		} else { // 비밀번호 답변을 입력받음
			System.out.println("비밀번호 입력 답변 : " + this.pwanswer);
			this.PassWordSearch(request, response);
		}
	}

	private void PassWordSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 비밀번호 답변까지 입력 받고 해당하는 비밀번호를 찾아주는 메소드
		request.setCharacterEncoding("UTF-8");

		this.id = request.getParameter("id");// 아이디
		this.phone = request.getParameter("phone");// 휴대폰 번호
		this.pwanswer = request.getParameter("pwanswer"); // 비밀번호 찾기 답변

		super.doPost(request, response);

		if (this.validate(request) == true) {
			// 유효성 검사 통과
			if (this.pwanswer.equals(bean.getPwanswer())) {
				// 파라미터 입력값과 기존 가입 당시 입력했던 비밀번호 찾기 답변이 같을때 패스워드 찾기 성공
				request.setAttribute("password_find", bean.getPassword());
				request.setAttribute("password_msg", "고객님의 정보와 일치하는 비밀번호입니다.");

				this.gotopage = "member/mePwSearch.jsp";
				super.GotoPage(gotopage);
			} else {
				// 파라미터 입력값과 기존 가입 당시 입력했던 비밀번호 찾기 답변이 다를때 패스워드 찾기 실패
				request.setAttribute(super.PREFIX + "password", "회원가입 당시 입력했던 비밀번호 찾기 답변과 일치하지 않습니다.");
				this.gotopage = "member/mePwSearch.jsp";
				super.GotoPage(gotopage);
			}
		} else {
			// 유효성 검사 통과 x
			request.setAttribute("id", this.id);
			request.setAttribute("phone", this.phone);
			request.setAttribute("pwanswer", this.pwanswer);

			this.gotopage = "member/mePwSearch.jsp";
			super.GotoPage(gotopage);
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		// 유효성 검사
		boolean isCheck = true;
		String regex = "";
		// 비밀번호 찾기 답변
		if (this.pwanswer != null) {
			regex = "^[a-zA-Z가-힣]*$";
			boolean pwanswer_result = Pattern.matches(regex, this.pwanswer);
			if (pwanswer_result == false) {
				request.setAttribute(super.PREFIX + "pwanswer", "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
				isCheck = false;
			}

			if (this.pwanswer.length() == 0) {
				request.setAttribute(super.PREFIX + "pwanswer", "해당 질문에 대한 답변을 입력하세요.");
				isCheck = false;
			}
		}

		// id : 영문 대문자 or 소문자 or 숫자로 시작 하고 , 길이는 4~15글자
		regex = "^[a-zA-Z0-9]{4,15}$";
		boolean id_result = Pattern.matches(regex, this.id);
		if (id_result == false) {
			request.setAttribute(super.PREFIX + "id", "4 ~ 15글자의 영문 대 소문자, 숫자만 사용이 가능합니다.");
			isCheck = false;
		}

		// id : 길이가 0일때
		if (this.id.length() == 0) {
			request.setAttribute(super.PREFIX + "id", "아이디를 입력하세요.");
			isCheck = false;
		}

		// 휴대폰 번호
		regex = "^[0-9]{10,11}$";
		boolean phone_result = Pattern.matches(regex, this.phone);
		if (phone_result == false) {
			request.setAttribute(super.PREFIX + "phone", "숫자 10 ~ 11자만 사용이 가능합니다.( - 하이픈 , 공백 사용 불가)");
			isCheck = false;
		}
		if (this.phone.startsWith("0") == false) {
			request.setAttribute(super.PREFIX + "phone", "올바른 휴대폰 번호 형식이 아닙니다.");
			isCheck = false;
		}
		if (this.phone.length() == 0) {
			request.setAttribute(super.PREFIX + "phone", "휴대폰 번호를 입력하세요.");
			isCheck = false;
		}
		return isCheck;
	}
}
