package mypkg.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;
import mypkg.utility.Paging;

public class MemberListController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();

		// 페이징 처리
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = request.getParameter("pageSize");
		int totalCount = dao.SelectTotalCount();
		System.out.println("회원목록 갯수 : " + totalCount);

		String contextPath = request.getContextPath();
		String myurl = contextPath + "/studycafe?command=meList";
		String mode = null;
		String keyword = null;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myurl, mode, keyword);

		List<Member> lists = dao.SelectAllData(pageInfo.getBeginRow(), pageInfo.getEndRow());

		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());

		super.doGet(request, response);
		String gotopage = "/member/meList.jsp";
		super.GotoPage(gotopage);
	}

}
