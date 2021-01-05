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

public class NotifyInsertController extends SuperClass{
	private Notice bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage ="/notify/noInsertForm.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest multi = (MultipartRequest) request.getAttribute("multi");
		
		bean = new Notice();
		
		bean.setContent(multi.getParameter("content"));
		bean.setRegdate(multi.getParameter("regdate"));
		bean.setRemark(multi.getParameter("remark"));
		bean.setTitle(multi.getParameter("title"));
		bean.setWriter(multi.getParameter("writer"));
		bean.setImage(multi.getFilesystemName("image"));
//		bean.setFix(multi.);
		
		if(multi.getParameter("fix")!=null && multi.getParameter("fix")!="") {
			bean.setFix(Integer.parseInt(multi.getParameter("fix")));
		}
//		if(multi.getParameter("groupno")!=null && multi.getParameter("groupno")!="") {
//			bean.setReadhit(Integer.parseInt(multi.getParameter("groupno")));
//		}
//		if(multi.getParameter("orderno")!=null && multi.getParameter("orderno")!="") {
//			bean.setReadhit(Integer.parseInt(multi.getParameter("orderno")));
//		}
//		if(multi.getParameter("depth")!=null && multi.getParameter("depth")!="") {
//			bean.setReadhit(Integer.parseInt(multi.getParameter("depth")));
//		}
		
		String gotopage="";
		
		if (this.validate(request)==false) {
			request.setAttribute("bean", bean);
			super.doPost(request, response);
			gotopage="notify/noInsertForm.jsp";
			super.GotoPage(gotopage);
		}else {
			NotifyDao ndao = new NotifyDao();
			int cnt = -9999999;
			cnt = ndao.InsertData(bean);
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
		if(bean.getFix() == 2) {
			request.setAttribute(super.PREFIX + "fix", "중요여부를 선택해주세요.");
			isCheck =false;
		}
		
		return isCheck ;
		
	}
}
