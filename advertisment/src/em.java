
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class em extends ActionSupport 
{
   private String from="your Email ID";
   private String password="your Email ID password";
   private String to;
   private String subject="Dodiya Amit";
   private String body="HI i am amit. this is Testing mail.... :) if any erorr then call me, my number is 7600898210";

   static Properties properties = new Properties();
   static
   {
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
   }

   public String execute() 
   {
      String ret = SUCCESS;
      try
      {
         Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {
            protected PasswordAuthentication 
            getPasswordAuthentication() {
            return new 
            PasswordAuthentication(from, password);
            }});

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse(to));
         message.setSubject(subject);
         message.setText(body);
         Transport.send(message);
      }
      catch(Exception e)
      {
         ret = ERROR;
         e.printStackTrace();
      }
      return ret;
   }

   
   public String getTo() 
   {
      return to;
   }

   public void setTo(String to) 
   {
      this.to = to;
   }

  
   public static Properties getProperties() {
      return properties;
   }

   public static void setProperties(Properties properties) {
      em.properties = properties;
   }
}
