import java.rmi.Naming;

public class HelloServer1 
{
  public static void main (String[] argv) 
  {
1 try 
  Naming.rebind 
    ("Hello1", new Hello1 ("Hello,From Roseindia.net pvt ltd!"));
  System.out.println 
   ("Server is connected and ready for operation.");
  } 
  catch (Exception e) {
  System.out.println ("Server not connected: " + e);
  }
  }
}