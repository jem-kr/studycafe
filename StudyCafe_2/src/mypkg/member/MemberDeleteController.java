package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberDeleteController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();

		int cnt  = -1;
		
		cnt = dao.DeleteDataById(id);
		
		if (cnt > -1) {
			System.out.println("회원 탈퇴 성공");
		}else {
			System.out.println("회원 탈퇴 실패");
		}
		
		super.doGet(request, response);
		super.session.setAttribute("message", "고객님의 모든 정보가 삭제되었습니다.");
		super.session.invalidate();
		String gotopage = "main/main.jsp";
		super.GotoPage(gotopage);
	}
}
