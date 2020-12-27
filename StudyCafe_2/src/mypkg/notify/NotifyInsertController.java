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
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		bean = new Notice();
		bean.setContent(multi.getParameter("content"));
		bean.setImage(multi.getFilesystemName("image"));
		bean.setRegdate(multi.getParameter("regdate"));
		bean.setTitle(multi.getParameter("title"));
		bean.setWriter(multi.getParameter("writer"));
		
		if(multi.getParameter("readhit")!=null && multi.getParameter("readhit")!="") {
			bean.setReadhit(Integer.parseInt(multi.getParameter("readhit")));
		}
		if( multi.getParameter("depth") != null && multi.getParameter("depth") != "" ){
			bean.setDepth( Integer.parseInt(multi.getParameter("depth") ));	
		}
		if( multi.getParameter("groupno") != null && multi.getParameter("groupno") != "" ){
			bean.setGroupno( Integer.parseInt(multi.getParameter("groupno") ));	
		}
		if( multi.getParameter("orderno") != null && multi.getParameter("orderno") != "" ){
			bean.setOrderno( Integer.parseInt(multi.getParameter("orderno") ));	
		}
		
		String gotopage = "";
		if (this.validate(request)==true) {
			NotifyDao ndao = new NotifyDao();
			int cnt = -999999;
			cnt = ndao.InsertData(bean);
			super.session.setAttribute("message", "공지사항을 작성했습니다.");
			new NotifyListController().doGet(request, response);
		}else {
			request.setAttribute("bean", bean);
			
			gotopage="/notify/noInsertForm.jsp";
			super.doPost(request, response);
			super.GotoPage(gotopage);
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
