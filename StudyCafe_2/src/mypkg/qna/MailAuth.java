package mypkg.qna;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

// 인증 부분과 보내기 부분으로 나누어 구현
// 인증 부분은 Auth
// 보내기 부분은 Send

// Authenticator : SMTP서버에 연결해 사용자 인증 하는 역할
// Authenticator를 사용하기 위해선 
// PasswordAuthenticator 클래스로부터 인스턴스를 생성하고 
// getPasswordAuthentication 메소드로 리턴받아야 함

public class MailAuth extends Authenticator{

    PasswordAuthentication pa;

    public MailAuth() {
    	//보낸사람
        String mail_id = "hellobit.sc@gmail.com";
        String mail_pw = "hellobit123!";
        
        pa = new PasswordAuthentication(mail_id, mail_pw);
    }
    
    public PasswordAuthentication getPasswordAuthentication() {
//    	getPasswordAuthentication
//    	: 사용자의 아이디와 패스워드를 입력받아 반환하도록 재정의

        return pa;
    }
	
}
