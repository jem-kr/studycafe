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
		
		super.doGet(request, response);
		
		super.session.invalidate();
		String gotopage = "main/main.jsp";
		super.GotoPage(gotopage);
	}
}
