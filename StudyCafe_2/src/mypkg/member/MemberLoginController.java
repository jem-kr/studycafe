package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberLoginController extends SuperClass {

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
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		MemberDao dao = new MemberDao();
		Member bean = dao.SelectByPk(id, password);

		HttpSession session = request.getSession();

		if (bean != null) {
			session.setAttribute("loginfo", bean);
			String gotopage = "main/main.jsp";
			response.sendRedirect(gotopage);
		} else {
			System.out.println("해당 id가 존재하지 않습니다.");
		}

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(request);
	}
}
