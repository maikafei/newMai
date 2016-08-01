package spring.apache;

import java.net.MalformedURLException;
import java.net.URL;
 

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

 

public class TestEmail {

    public static String sendHtml() throws EmailException, MalformedURLException{  
        // 创建邮件信息  
        String result = null;  
        HtmlEmail email = new HtmlEmail();  
        email.setHostName("host");  
        email.addTo("guanpeng@newangels.cn");  
        email.setFrom("AA");  
        email.setSubject("BB");  
        // embed the image and get the content id  
        URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");  
        String cid = email.embed(url, "Apache logo");  
        // set the html message  
        email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");  
        // set the alternative message  
        email.setTextMsg("Your email client does not support HTML messages");  
        // send the email  
        email.send();  
          
        return result;  
    }  
	
	public static void main(String[] args) throws MalformedURLException, EmailException {
		
		
		sendHtml();
		
		/*Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("user@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();*/
	}
	
	
}
