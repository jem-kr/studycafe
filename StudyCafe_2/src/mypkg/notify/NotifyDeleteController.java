package mypkg.notify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.NotifyDao;

public class NotifyDeleteController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		NotifyDao ndao = new NotifyDao();
		
		int cnt = -9999999;
		cnt = ndao.DeleteData(num);
	
		new NotifyListController().doGet(request, response);
		
	}
}
