package mypkg.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;

public class ProductFacController extends SuperClass{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gotopage = "product/prFac.jsp";//시설 소개 페이지
		
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}
}
