package mypkg.member;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberUpdateController extends SuperClass {
	Member bean = null;
	String gotopage = "";
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		MemberDao dao = new MemberDao();
		Member bean = dao.SelectDataId(id);

		request.setAttribute("bean", bean);

		this.gotopage = "member/meUpdate.jsp";
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		bean = new Member();

		bean.setBirth(request.getParameter("birth"));
		bean.setEmail01(request.getParameter("email01"));
		bean.setEmail02(request.getParameter("email02"));
		bean.setGender(request.getParameter("gender"));
		bean.setName(request.getParameter("name"));
		bean.setPhone(request.getParameter("phone"));
		bean.setPwanswer(request.getParameter("pwanswer"));
		bean.setPwquestion(request.getParameter("pwquestion"));
		bean.setVisit(request.getParameterValues("visit"));

		super.doPost(request, response);
		if (this.validate(request) == true) {
			// 유효성 검사 통과

		} else {
			// 유효성 검사 통과 안됨
			request.setAttribute("birth", bean.getBirth());
			request.setAttribute("name", bean.getName());
			request.setAttribute("email01", bean.getEmail01());
			request.setAttribute("email02", bean.getEmail02());
			request.setAttribute("gender", bean.getGender());
			request.setAttribute("phone", bean.getPhone());
			request.setAttribute("pwanswer", bean.getPwanswer());
			request.setAttribute("pwquestion", bean.getPwquestion());
			request.setAttribute("visit", bean.getVisit());
			
			
			this.gotopage = "member/meUpdate.jsp";
			super.GotoPage(gotopage);
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;

		String regex = "";
		// 이름 : 한글과 영문 대 소문자. (특수기호, 공백 사용 불가)
		regex = "^[a-zA-Z가-힣]*$";
		boolean name_result = Pattern.matches(regex, bean.getName());
		if (name_result == false) {
			request.setAttribute(super.PREFIX + "name", "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
			isCheck = false;
		}

		// 이름의 길이가 0일 때
		if (bean.getName().length() == 0) {
			request.setAttribute(super.PREFIX + "name", "이름을 입력하세요.");
			isCheck = false;
		}

		// 성별 체크가 안 되었을 때
		if (bean.getGender() == null) {
			request.setAttribute(super.PREFIX + "gender", "성별을 선택하세요.");
			isCheck = false;
		}

		// 생년 월일
		regex = "^[0-9]{8}$";
		boolean birth_result = Pattern.matches(regex, bean.getBirth());
		if (birth_result == false) {
			request.setAttribute(super.PREFIX+"birth", "생년월일 숫자 8자리를 입력하세요.(ex. 20210101)");
			isCheck = false;
		}
		
		if (bean.getBirth().startsWith("1") == false || bean.getBirth().startsWith("2") == false ) {
			request.setAttribute(super.PREFIX+"phone", "올바른 생년월일 형식이 아닙니다.");
			isCheck = false;
		}
		
		// 생년 월일 길이가 0일 때
		if (bean.getBirth().length() == 0) {
			request.setAttribute(super.PREFIX + "birth", "생년월일 숫자 8자리를 입력하세요.(ex. 20210101)");
			isCheck = false;
		}

		// 휴대폰 번호
		regex = "^[0-9]{10,11}$";
		boolean phone_result = Pattern.matches(regex, bean.getPhone());
		if (phone_result == false) {
			request.setAttribute(super.PREFIX + "phone", "휴대폰 번호 숫자 10 ~ 11자리를 입력하세요.");
			isCheck = false;
		}
		
		if (bean.getPhone().startsWith("0") == false) {
			request.setAttribute(super.PREFIX+"phone", "올바른 휴대폰 번호 형식이 아닙니다.(- 하이픈 , 공백 사용 불가)");
			isCheck = false;
		}

		if (bean.getPhone().length() == 0) {
			request.setAttribute(super.PREFIX + "phone", "휴대폰 번호를 입력하세요.(- 하이픈 , 공백 사용 불가)");
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
			request.setAttribute(super.PREFIX + "email01", "이메일 주소를 입력하세요.");
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

		return isCheck;
	}
}
