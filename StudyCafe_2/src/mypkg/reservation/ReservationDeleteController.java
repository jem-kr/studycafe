package mypkg.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.SuperClass;
import mypkg.dao.ReservationDao;

public class ReservationDeleteController extends SuperClass{
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String re_id = request.getParameter("re_id");
	ReservationDao rdao = new ReservationDao();
	
	int cnt = -9999999;
	cnt = rdao.DeleteData(re_id);

}
	
	
}
