package mypkg.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mypkg.common.SuperController;

public class Myutility {

	public static Map<String, SuperController> getActionMapList(String todolist) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		Map<String, SuperController> mapdata
			= new HashMap<String, SuperController>();
		
		try {
			fis = new FileInputStream(todolist);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {fis.close();}
			} catch (Exception e2) {
			e2.printStackTrace();
			}
			
		}
		
		System.out.println("prop.toString()");
		System.out.println(prop.toString());
		
		Enumeration<Object> enu = prop.keys();
		
		while(enu.hasMoreElements()) {
			String command = enu.nextElement().toString();
			String className = prop.getProperty(command);
			
		try {
			Class<?> handleClass = Class.forName(className);
			
			SuperController instance = 
					(SuperController)handleClass.newInstance();
			
			mapdata.put(command, instance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		System.out.println("mapdata.toString()");
		System.out.println(mapdata.toString());
			
		return mapdata;
	
		}

	public static MultipartRequest getMultiPartRequest(HttpServletRequest request, String uploadedPath) {
				String encType = "UTF-8"; //문자열 인코딩
				int sizeLimit = 20 * 1024 * 1024; //업로드 허용 최대 사이즈
				MultipartRequest multi = null ; //파일 업로드 객체		
				try {
					multi = new MultipartRequest(request, uploadedPath, sizeLimit,
							encType, new DefaultFileRenamePolicy());			
				} catch (IOException e) {
					multi = null;
					e.printStackTrace();
				}		
				return multi ;
	}

	}
