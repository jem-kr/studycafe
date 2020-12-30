package mypkg.notify;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import mypkg.bean.Notice;
import mypkg.common.SuperClass;
import mypkg.dao.NotifyDao;

public class NotifyUpdateController extends SuperClass{
	private Notice bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		NotifyDao ndao = new NotifyDao();
		bean = ndao.SelectDataByPk(num);
		
		
		request.setAttribute("bean", bean);
		super.doGet(request, response);
		String gotopage = "notify/noUpdateForm.jsp";
		
		super.GotoPage(gotopage);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest mr =  (MultipartRequest) request.getAttribute("multi");
		
		bean = new Notice();
		bean.setNum(Integer.parseInt(mr.getParameter("num")));
		bean.setContent(mr.getParameter("content"));
		bean.setRegdate(mr.getParameter("regdate"));
		bean.setRemark(mr.getParameter("remark"));
		bean.setTitle(mr.getParameter("title"));
		bean.setWriter(mr.getParameter("writer"));
		bean.setImage(mr.getFilesystemName("image"));
		
		System.out.println(bean);
		String gotopage="";
		
		if (this.validate(request)==false) { // 유효성 검사 실패
			request.setAttribute("bean", bean);
			gotopage="notify/noUpdateForm.jsp";
			super.doPost(request, response);
			super.GotoPage(gotopage);
		}else {	//유효성 검사 통과
			NotifyDao ndao = new NotifyDao();
			int cnt = -9999999;
			cnt = ndao.UpdateData(bean);
			new NotifyListController().doGet(request, response);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck=true;
		
		if(bean.getTitle().length()<3 || bean.getTitle().length()>20) {
			request.setAttribute(super.PREFIX+"title", "제목은 4~20자로 입력하세요.");
			isCheck=false;
		}
		
		if(bean.getContent().length()<10 ) {
			request.setAttribute(super.PREFIX+"content", "내용은 최소 10자이상 입력하세요.");
			isCheck=false;
		}
		
		String regex = "\\d{4}[-/]\\d{2}[-/]\\d{2}" ;
		if( bean.getRegdate() == null){
			bean.setRegdate( "" );
		}
		boolean result = Pattern.matches(regex, bean.getRegdate());
		if (result == false ) {
			request.setAttribute(super.PREFIX + "regdate", "날짜는 yyyy/MM/dd 또는 yyyy-MM-dd 형식으로 입력해 주세요.");
			isCheck = false  ;
		}
		return isCheck ;
	}
	
	
}
