package mypkg.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.MemberDao;

public class MemberDetailViewController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		
		MemberDao dao = new MemberDao();
		Member bean = dao.SelectDataId(id);
		
		//문자열 짜집기
		String _gender = bean.getGender() + "성";
		bean.setGender(_gender);
		
		String _year = bean.getBirth().substring(0,4) + "년 ";
		String _month = bean.getBirth().substring(4,6) + "월 ";
		String _day = bean.getBirth().substring(6) + "일 ";
		String _birth = _year.concat(_month).concat(_day);
		bean.setBirth(_birth);
		
		String p_start = bean.getPhone().substring(0,3)+" - ";
		
		String p_center = "";
		String p_end = ""; 
		if (bean.getPhone().length() == 10) {//016-123-4567		
			p_center = bean.getPhone().substring(3,6) + " - ";
			p_end = bean.getPhone().substring(6);
		}else {//010-1234-5678		
			p_center = bean.getPhone().substring(3,7) + " - ";
			p_end = bean.getPhone().substring(7);
		}
		String _phone = p_start.concat(p_center).concat(p_end);
		bean.setPhone(_phone);
		
		request.setAttribute("bean", bean);
		
		String gotopage = "member/meDetailView.jsp";
		super.doGet(request, response);
		super.GotoPage(gotopage);
	}

}
