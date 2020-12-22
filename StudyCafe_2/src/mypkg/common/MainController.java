package mypkg.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("안녕하세요");
		String gotopage = "/main/main.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(gotopage);
		dispatcher.forward(request, response);
		
		
	}
	
}
