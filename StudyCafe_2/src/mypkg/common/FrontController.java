package mypkg.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.utility.Myutility;

@WebServlet(urlPatterns = { "/studycafe" }, initParams = {
		@WebInitParam(name = "configFile", value = "/WEB-INF/todolist.txt", description = "todolist") })
public class FrontController extends HttpServlet {
	private Map<String, SuperController> todolist 
		= new HashMap<String, SuperController>();
	
	private ServletContext application = null;
	
	private static final long serialVersionUID = 1L;

	public FrontController() {
	}
	

	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile 파일 경로 확인 : " + configFile);
		this.application = config.getServletContext();
		String configFilePath = this.application.getRealPath(configFile);
		this.todolist = Myutility.getActionMapList(configFilePath);
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);

	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");		
		SuperController controller = this.todolist.get(command);
		
		if (controller != null) {
			String method = request.getMethod().toLowerCase();
			if (method.equals("get")) {
				System.out.println(controller.toString() + "doGet방식");
				controller.doGet(request, response);
			} else {
				System.out.println(controller.toString() + "doPost방식");
				controller.doPost(request, response);
			}
			
		} else {
			System.out.println("command가 null입니다.");
		}
		
		
	}
	
	

}
