package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mypkg.common.MainController;
import mypkg.common.SuperClass;

public class MemberLogoutController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//장바구니를 담기 → 로그아웃 → 다시 로그인 → 장바구니 내역이 살아있어야함 
		//추후 개발 예정 
		
		
		
		super.doGet(request, response);
		
		super.session.invalidate();
		
		String gotopage = "main/main.jsp";
		super.GotoPage(gotopage);
	}
}
