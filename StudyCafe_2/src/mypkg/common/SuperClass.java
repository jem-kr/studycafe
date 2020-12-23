package mypkg.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuperClass implements SuperController, Validator {

	public static final String PREFIX = "err";
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	protected HttpSession session = null;

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	@Override
	public boolean validate(HttpServletRequest request) {
		return true;
	}

	public void GotoPage(String url) {
		RequestDispatcher dispatcher = this.request.getRequestDispatcher(url);

		try {
			dispatcher.forward(this.request, this.response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setErrorMessage(String message) {
		// request 영역에 "errmsg"이라는 이름으로 오류 메세지를 바인딩 한다.
		// 오류 메세지는 common.jsp 파일의 하단에서 보여 준다.
		this.request.setAttribute("errmsg", message);
	}

}
