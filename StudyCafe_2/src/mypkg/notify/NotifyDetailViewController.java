package mypkg.notify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NotifyDao;
import mypkg.utility.FlowParameters;

public class NotifyDetailViewController extends SuperClass {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		NotifyDao ndao = new NotifyDao();
		Notice bean = ndao.SelectDataByPk(num);
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"),
				request.getParameter("pageSize"),
				request.getParameter("mode"),
				request.getParameter("keyword"));
		
		super.doGet(request, response);
		
		if(bean!=null) {
			if(!bean.getWriter().equals("관리자")) {
				ndao.UpdateReadhit(num);
			}
			request.setAttribute("bean", bean);
			request.setAttribute("parameters", parameters.toString());
			
			String gotopage="notify/noDetailView.jsp";
			super.GotoPage(gotopage);
		}else {
			new NotifyListController().doGet(request, response);
			
		}
	}
	
	
	
}
