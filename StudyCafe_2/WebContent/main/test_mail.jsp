<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="mypkg.qna.*"  %>
 
<%
	MailSend ms = new MailSend();
	ms.MailSend();
 
	out.println("COMPLETE");
%>


