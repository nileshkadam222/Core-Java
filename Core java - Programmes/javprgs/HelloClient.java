import java.rmi.Naming;

public class HelloClient 
{
  public static void main (String[] argv) {
  try {
HelloInterface hello =(HelloInterface)
  Naming.lookup ("//127.0.0.1/Hello");
  System.out.println (hello.say());
  } 
  catch (Exception e){
  System.out.println ("HelloClient exception: " + e);}
  }
}