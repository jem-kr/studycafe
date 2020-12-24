package mypkg.notify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NotifyDao;
import mypkg.utility.FlowParameters;
import mypkg.utility.Paging;

public class NotifyListController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NotifyDao ndao = new NotifyDao();
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"),
				request.getParameter("pageSize"),
				request.getParameter("mode"), 
				request.getParameter("keyword"));
		System.out.println(this.getClass() + " : " +parameters.toString());

		
		int totalCount= ndao.SelectTotalCount(
				parameters.getMode(), parameters.getKeyword()
				);
		
		String contextPath = request.getContextPath();
		String myurl = contextPath+ "/studycafe?command=noList";
		
		Paging pageinfo = new Paging(
				parameters.getPageNumber(),
				parameters.getPageSize(),
				totalCount,
				myurl,
				parameters.getMode(),
				parameters.getKeyword()
				);
		
		List<Notice>lists = ndao.SelectDataList(
				pageinfo.getBeginRow(),
				pageinfo.getEndRow(),
				parameters.getMode(),
				parameters.getKeyword()+"%"	);
		
		request.setAttribute("lists", lists);
		
		request.setAttribute("pagingHtml", pageinfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageinfo.getPagingStatus());
		
		request.setAttribute("mode", parameters.getMode());
		request.setAttribute("keyword", parameters.getKeyword());
		request.setAttribute("parameters", parameters.toString());
		
		
		super.doGet(request, response);
		
		String gotopage="notify/noList.jsp";
		super.GotoPage(gotopage);
				
	}
	
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		return isCheck;
	}
}
