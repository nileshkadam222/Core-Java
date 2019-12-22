import java.rmi.Naming;
import java.util.Date;
import java.rmi.registry.*;
import java.rmi.server.*;

public class HelloClient1 
{
  public static void main (String[] argv) {
  try {
HelloInterface1 hello =(HelloInterface1)
  Naming.lookup ("//127.0.0.1/Hello1");
  System.out.println (hello.say());
   Date d = hello.getDate();
   System.out.println("Date on server is " + d);
                 
  } 
  catch (Exception e){
  System.out.println ("HelloClient exception: " + e);}
  }
}