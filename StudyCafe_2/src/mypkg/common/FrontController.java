package mypkg.common;

import java.io.File;
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

import com.oreilly.servlet.MultipartRequest;

import mypkg.utility.Myutility;

@WebServlet(urlPatterns = { "/studycafe" }, initParams = {
		@WebInitParam(name = "configFile", value = "/WEB-INF/todolist.txt", description = "todolist"),
		@WebInitParam(name = "debugMode", value = "false") })
public class FrontController extends HttpServlet {
	private Map<String, SuperController> todolist 
		= new HashMap<String, SuperController>();
	
	private ServletContext application = null;
	private String uploadedPath = null;
	private static final long serialVersionUID = 1L;

	
@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile 파일 경로 확인 : " + configFile);
		
		String debugMode = config.getInitParameter("debugMode");
		
		this.application = config.getServletContext();
		
		String configFilePath = this.application.getRealPath(configFile);
		this.todolist = Myutility.getActionMapList(configFilePath);
		
		this.application.setAttribute("debugMode", debugMode);
		
		this.uploadedPath = this.application.getRealPath("/upload");
		this.application.setAttribute("uploadedPath", uploadedPath);
		System.out.println("파일 업로드 경로 : \n" +uploadedPath );
		
	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);

		
	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);

	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String command = request.getParameter("command");	
		
		if (command == null) {
			System.out.println("파일 업로드를 수행합니다.");
			MultipartRequest multi = Myutility.getMultiPartRequest(request, uploadedPath);
			if (multi !=null) {
				command = multi.getParameter("command");
				
				
				// delete_image : 이전에 업로드 했던 이미지 입니다.
				// 이 파라미터는 상품 수정 페이지에서 넘어옵니다.
				String delete_image = multi.getParameter("image");
				System.out.println("삭제할 이미지 이름 : " + delete_image);
				//삭제될 이미지체 경로를 구합니다. 
				String delete_file = this.uploadedPath+"/"+delete_image;
				System.out.println("삭제할 파일 : " + delete_file);
				// File 객체를 구합니다.
				File delfile =  new File(delete_file);
				delfile.delete(); // file객체의 delete()메소드를 이용하여 이전에 업로드 한 이미지 파일을 삭제합니다. 
				
				//파일 업로드 객체를 바인딩
				request.setAttribute("multi", multi);
			}else {
				System.out.println("MultiPartRequest 객체를 구하지 못했습니다.");
			}
		} 
		
		SuperController controller = this.todolist.get(command);
		if (controller != null) {
			String method = request.getMethod().toLowerCase();
			if (method.equals("get")) {
				System.out.println(controller.toString() + " doGet방식");
				controller.doGet(request, response);
			} else {
				System.out.println(controller.toString() + " doPost방식");
				controller.doPost(request, response);
			}
			
		} else {
			System.out.println("command가 null입니다.");
		}
		
		
		
	}
	
	

}
