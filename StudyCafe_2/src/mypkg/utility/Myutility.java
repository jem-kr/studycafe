package mypkg.utility;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
	}
