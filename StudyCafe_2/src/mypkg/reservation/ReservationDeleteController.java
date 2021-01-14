package mypkg.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.bean.Member;
import mypkg.common.SuperClass;
import mypkg.dao.ReservationDao;

public class ReservationDeleteController extends SuperClass{
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doGet(request, response);
	Member loginfo = (Member)super.session.getAttribute("loginfo");
	
	ReservationDao rdao = new ReservationDao();
	
	int cnt = -9999999;
	cnt = rdao.DeleteData(loginfo.getId());

}
	
	
}
