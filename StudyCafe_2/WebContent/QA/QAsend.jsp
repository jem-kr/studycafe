<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.mail.Transport" %>
<%@ page import="javax.mail.Message" %>
<%@ page import="javax.mail.Address" %>
<%@ page import="javax.mail.internet.InternetAddress" %>
<%@ page import="javax.mail.internet.MimeMessage" %>
<%@ page import="javax.mail.Session" %>
<%@ page import="javax.mail.Authenticator" %>
<%@ page import="java.util.Properties" %>
<%@ page import="mypkg.dao.MemberDao" %>
<%@ page import="mypkg.utility.SHA256" %>
<%@ page import="mypkg.utility.Gmail" %>
<%@ page import="java.io.PrintWriter" %>
<%
	MemberDao memberDao = new MemberDao();
	String ID = null;
	if(session.getAttribute("ID") != null ) {
		ID = (String) session.getAttribute("ID");
	}

	request.setCharacterEncoding("UTF-8");
	String message = null;
	 
	if(request.getParameter("message") != null) {
		message = request.getParameter("message");		
	}
	
	if(message == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}

	
	String host = "http://localhost:8989/StudyCafe_2/studycafe?command=";
	String from = "구글 이메일 계정"; 
	String to = "hellobitcamp@gmail.com";
	String subject = "스터디카페 문의 메일입니다.";
	String content = "문의자 : " + Id +
					"<br>내용 : " + message;
		
	Properties p = new Properties();
	

	
%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의</title>
</head>
<body>
	<!-- 
		관리자의 이메일로 문의 내용이 전달될 수 있도록 작성하기
	 -->


</body>
</html>