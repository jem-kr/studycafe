package mypkg.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Product;
import mypkg.common.SuperClass;
import mypkg.dao.ProductDao;
import mypkg.utility.FlowParameters;
import mypkg.utility.Paging;

public class ProductListController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlowParameters parameters 
			= new FlowParameters(
					request.getParameter("pageNumber"), 
					request.getParameter("pageSize"), 
					request.getParameter("mode"), 
					request.getParameter("keyword")) ;
		
		System.out.println(this.getClass() + " : " + parameters.toString());
		
		ProductDao dao = new ProductDao();
		
		int totalCount 
				= dao.SelectTotalCount(
						parameters.getMode(), 
						parameters.getKeyword() + "%");
		
		String contextPath = request.getContextPath() ;
		String myurl = contextPath + "/studycafe?command=prList" ;
		
		Paging pageInfo = new Paging(
				parameters.getPageNumber(), 
				parameters.getPageSize(), 
				totalCount, 
				myurl, 
				parameters.getMode(), 
				parameters.getKeyword()) ;
		
		List<Product> lists = dao.SelectDataList(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(),
				parameters.getMode(), 
				parameters.getKeyword() + "%");
		
		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());
		request.setAttribute("mode", parameters.getMode());
		request.setAttribute("keyword", parameters.getKeyword());
		request.setAttribute("parameters", parameters.toString());		
		
		super.doGet(request, response);
		String gotopage = "product/prList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String gotopage = "" ;
		if (this.validate(request) == true) {
			gotopage = "" ;
			super.GotoPage(gotopage);
		}else {
			gotopage = "" ;
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true ;	
		return isCheck ;
	}
	
}