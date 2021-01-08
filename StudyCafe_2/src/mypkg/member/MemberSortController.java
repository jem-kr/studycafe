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

public class MemberSortController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();
		List<Member> lists = null;
		
		// jsp 파라미터
		String sort = request.getParameter("sort");// 정렬 기준
		String asc = request.getParameter("asc");// 오름차순 버튼 클릭
		String desc = request.getParameter("desc");// 내림차순 버튼 클릭
		
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
		
		
		super.doPost(request, response);

		if (asc != null && desc == null) { // 오름차순 버튼을 클릭했을 때
			lists = dao.SelectAllDataASC(sort, pageInfo.getBeginRow(), pageInfo.getEndRow());
		} else if (asc == null && desc != null) { // 내림차순 버튼을 클릭했을 때
			lists = dao.SelectAllDataDESC(sort, pageInfo.getBeginRow(), pageInfo.getEndRow());
		}

		request.setAttribute("lists", lists);
		request.setAttribute("pagingHtml", pageInfo.getPagingHtml());
		request.setAttribute("pagingStatus", pageInfo.getPagingStatus());

		String gotopage = "/member/meList.jsp";
		super.GotoPage(gotopage);
	}
}
