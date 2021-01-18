package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberInsertController extends SuperClass {
	Member bean = null;

	String pwCheck = null;
	String hp_second = null;

	String gotopage = ""; // 페이지 이동

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		this.gotopage = "member/meInsertForm.jsp";
		super.GotoPage(this.gotopage);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		bean = new Member();

		// id
		bean.setId(request.getParameter("id"));
		// 패스워드
		bean.setPassword(request.getParameter("password"));

		// 패스워드 재확인
		this.pwCheck = request.getParameter("pwCheck");
		// 이름
		bean.setName(request.getParameter("name"));
		// 성별
		bean.setGender(request.getParameter("gender"));

		// 생년월일
		String _birth = null;

		_birth = (request.getParameter("year").concat(request.getParameter("month")))
				.concat(request.getParameter("day"));
		bean.setBirth(_birth);

		//System.out.println("birth==>>" + _birth);

		// 휴대폰 번호
		String hp_first = request.getParameter("hp_first");
		this.hp_second = request.getParameter("hp_second");
//		System.out.println(hp_first);
//		System.out.println(hp_second);
		bean.setPhone(hp_first.concat(this.hp_second));
//		System.out.println(bean.getPhone());

		// 이메일01
		bean.setEmail01(request.getParameter("email01"));
		// 이메일02
		bean.setEmail02(request.getParameter("email02"));

		// 비밀번호 질문
		bean.setPwquestion(request.getParameter("pwquestion"));

		// 비밀번호 답변
		bean.setPwanswer(request.getParameter("pwanswer"));

		// 방문목적

		
		bean.setVisit(request.getParameterValues("visit"));
		

		// 개인정보 동의
		bean.setAgreement(request.getParameter("agreement"));
		// System.out.println("개인정보 동의 ===> " + bean.getAgreement());

		// 비고
		bean.setRemark("");

		if (this.validate(request) == false) {
			// 유효성 검사 통과 못함
			this.gotopage = "member/meInsertForm.jsp";

			request.setAttribute("bean", bean);
			request.setAttribute("pwCheck", this.pwCheck);
			request.setAttribute("hp_second", this.hp_second);
			super.doPost(request, response);
			super.GotoPage(this.gotopage);
		} else {
			// 유효성 검사 통과
			// System.out.println("회원 가입 유효성 검사 통과");

			MemberDao dao = new MemberDao();

			int cnt = -1; // 기본값 음수로 지정

			cnt = dao.MemberInsertData(bean);

			this.gotopage = "member/meLoginForm.jsp";

			super.doPost(request, response);
			session.setAttribute("message", "회원가입을 성공했습니다. 더 많은 정보를 보려면 로그인을 해주세요.");
			super.GotoPage(gotopage);
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true; // 기본값 true

		// id : 영문 대문자 or 소문자 or 숫자로 시작 하고 , 길이는 4~15글자
		String regex = "^[a-zA-Z0-9]{4,15}$";
		boolean id_result = Pattern.matches(regex, bean.getId());
		if (id_result == false) {
			request.setAttribute(super.PREFIX + "id", "4 ~ 15글자의 영문 대 소문자, 숫자만 사용이 가능합니다.");
			isCheck = false;
		}

		// id : 길이가 0일때
		if (bean.getId().length() == 0) {
			request.setAttribute(super.PREFIX + "id", "필수 정보입니다.");
			isCheck = false;
		}

		// password : 영문 대문자 or 소문자 or 숫자로 시작 하고 , 길이는 5~15글자
		regex = "^[a-zA-Z0-9]{5,15}$";
		boolean pw_result = Pattern.matches(regex, bean.getPassword());
		if (pw_result == false) {
			request.setAttribute(super.PREFIX + "password", "5 ~ 15글자의 영문 대 소문자, 숫자만 사용이 가능합니다.");
			isCheck = false;
		}

		// password : 길이가 0일때
		if (bean.getPassword().length() == 0) {
			request.setAttribute(super.PREFIX + "password", "필수 정보입니다.");
			isCheck = false;
		}

		// 비밀번호 재확인
		if (this.pwCheck.equals(bean.getPassword()) == false) {
			request.setAttribute(super.PREFIX + "pwCheck", "비밀번호가 일치하지 않습니다.");
			isCheck = false;
		}

		if (this.pwCheck.length() == 0) {
			request.setAttribute(super.PREFIX + "pwCheck", "필수 정보입니다.");
			isCheck = false;
		}

		// 이름 : 한글과 영문 대 소문자. (특수기호, 공백 사용 불가)
		regex = "^[a-zA-Z가-힣]*$";
		boolean name_result = Pattern.matches(regex, bean.getName());
		if (name_result == false) {
			request.setAttribute(super.PREFIX + "name", "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
			isCheck = false;
		}

		// 이름의 길이가 0일 때
		if (bean.getName().length() == 0) {
			request.setAttribute(super.PREFIX + "name", "필수 정보입니다.");
			isCheck = false;
		}

		// 성별 체크가 안 되었을 때
		if (bean.getGender() == null) {
			request.setAttribute(super.PREFIX + "gender", "필수 정보입니다.");
			isCheck = false;
		}

		// 생년 월일
		// 순서 ) 일 → 월 → 년도 순서로 체크
		if (bean.getBirth().contains("일")) {
			request.setAttribute(super.PREFIX + "birth", "태어난 일을 선택하세요.");
			isCheck = false;
		}
		if (bean.getBirth().contains("월")) {
			request.setAttribute(super.PREFIX + "birth", "태어난 월을 선택하세요.");
			isCheck = false;
		}
		if (bean.getBirth().contains("년")) {
			request.setAttribute(super.PREFIX + "birth", "태어난 년도를 선택하세요.");
			isCheck = false;
		}

		// 휴대폰 번호
		regex = "^[0-9]{7,8}$";
		boolean hp_second_result = Pattern.matches(regex, this.hp_second);
		if (hp_second_result == false) {
			request.setAttribute(super.PREFIX + "hp_second", "7 ~ 8글자의 숫자만 사용이 가능합니다.( - 하이픈 , 공백 사용 불가)");
			isCheck = false;
		}

		if (this.hp_second.length() == 0) {
			request.setAttribute(super.PREFIX + "hp_second", "필수정보 입니다.");
			isCheck = false;
		}

		// email01
		regex = "^[a-zA-Z0-9]{5,20}$";
		boolean email01_result = Pattern.matches(regex, bean.getEmail01());
		if (email01_result == false) {
			request.setAttribute(super.PREFIX + "email01",
					"5 ~ 20글자의 영문 대 소문자, 숫자만 사용이 가능합니다." + "<br>(특수기호, 공백 사용 불가)");
			isCheck = false;
		}

		if (bean.getEmail01().length() == 0) {
			request.setAttribute(super.PREFIX + "email01", "필수정보 입니다.");
			isCheck = false;
		}

		// 비밀번호 찾기 > 질문
		if (bean.getPwquestion().equals("-")) {
			request.setAttribute(super.PREFIX + "pwquestion", "질문을 선택하세요.");
			isCheck = false;
		}

		// 비밀번호 찾기 > 답변
		regex = "^[a-zA-Z가-힣]*$";
		boolean pwanswer_result = Pattern.matches(regex, bean.getPwanswer());
		if (pwanswer_result == false) {
			request.setAttribute(super.PREFIX + "pwanswer", "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
			isCheck = false;
		}

		if (bean.getPwanswer().length() == 0) {
			request.setAttribute(super.PREFIX + "pwanswer", "해당 질문에 대한 답변을 입력하세요.");
			isCheck = false;
		}
		
		// 방문 목적 
		if (bean.getVisit().length() == 0) {
			request.setAttribute(super.PREFIX + "visit", "방문 목적을 1개 이상 체크 해주세요.");
			isCheck = false;
		}

		// 개인 정보 동의
		if (bean.getAgreement() == null) {
			request.setAttribute(super.PREFIX + "agreement", "개인정보 수집 및 이용에 대한 동의를 체크 해주세요.");
			isCheck = false;
		}

		return isCheck;
	}

}
