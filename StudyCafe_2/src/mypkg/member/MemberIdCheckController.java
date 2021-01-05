package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberIdCheckController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("meIdCheck 커맨드 발견");
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		
		Member bean = dao.SelectDataId(id);
		
		
		if (bean == null) {
			// 해당하는 id를 발견하지 못했을 때(= 중복된 id가 존재하지 않는다면)
			request.setAttribute("idCheck_msg", "<b>사용가능한 아이디 입니다.</b>");
			request.setAttribute("isCheck", true);
		} else {
			// 해당하는 id를 발견했을 때
			request.setAttribute("idCheck_msg", "이미 가입하였거나 탈퇴한 아이디 입니다.<br><b>다른 아이디를 사용하세요.</b>");
			request.setAttribute("isCheck", false);
		}
		
		super.doGet(request, response);
		String gotopage = "member/meIdCheck.jsp";
		super.GotoPage(gotopage);
	}
}
