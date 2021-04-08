package mypkg.qna;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypkg.common.MainController;
import mypkg.common.SuperClass;
 
public class MailSend extends SuperClass {
	String email = "";
	String e_msg = "";
	
	
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.email = request.getParameter("email");
    	this.e_msg = request.getParameter("e_msg");
    	
    	this.Mailsend();
    	
    	String gotopage = "main/main.jsp";
    	super.doPost(request, response);
    	session.setAttribute("message", "문의 메일이 전송되었습니다!");
    	super.GotoPage(gotopage);
    	
    }
    
    public void Mailsend() throws UnsupportedEncodingException {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true"); // 로그인시 TLS를 사용할 것인지 설정
        prop.put("mail.smtp.host", "smtp.gmail.com"); // 이메일 발송을 처리해줄 SMTP서버
        prop.put("mail.smtp.auth", "true"); // SMTP 서버의 인증을 사용한다는 의미
        prop.put("mail.smtp.port", "587"); // TLS의 포트번호는 587이며 SSL의 포트번호는 465

        //QnasendController에서 Authenticator를 상속받아 생성한
        //QnasendController 클래스를 받아 세션을 생성
        Authenticator auth = new MailAuth();
        
        Session session = Session.getDefaultInstance(prop, auth);
        
        MimeMessage msg = new MimeMessage(session);
    
        try {
            msg.setSentDate(new Date()); //보내는 날짜 지정
           
//          Message 클래스의 setFrom() 메소드를 사용하여 발송자를 지정함. 발송자의 메일, 발송자 명
//          InternetAddress 클래스는 이메일 주소 나타낼 때 사용하는 클래스
            System.out.println("이메일 파라미터 확인 ==> " + email);
            
            msg.setFrom(new InternetAddress (email));
            
//          수신자 메일 생성 : 관리자 admin의 메일...
            InternetAddress to = new InternetAddress("hellobit.sc@gmail.com");         
            
//          Message 클래스의 setRecipient() 메소드를 사용하여 수신자를 설정
//          메인 페이지의 QnA 뷰의 value에 입력된 값을 메일 내용으로 작성합니다.
            msg.setRecipient(Message.RecipientType.TO, to); //받는 사람
            msg.setSubject("[QnA]그...스터디카페 문의글입니다.", "UTF-8");
            msg.setText("문의자 이메일 주소 : " + this.email + "\n문의 내용 : " + this.e_msg, "UTF-8"); // 메일 내용
            
            System.out.println("문의자 이메일 주소 : " + this.email + "\n문의 내용 : " + this.e_msg);
            
            Transport.send(msg); // 메일을 최종적으로 보내는 클래스 : 메일을 보내는 부분
          
//			예외 처리
        } catch(AddressException ae) {            
            System.out.println("AddressException : " + ae.getMessage());           
        } catch(MessagingException me) {            
//        	MessagingException : 메일 계정인증 관련 예외 처리
        	System.out.println("MessagingException : " + me.getMessage());
        	
        }      
    }
}


