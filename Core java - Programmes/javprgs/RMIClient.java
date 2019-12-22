import java.rmi.*;
import java.rmi.registry.*;
public class RMIClient
{
    public static void main(String args[])
    {
        try
        {
             MethodInter mthdimp=(MethodInter)Naming.lookup("rmi://localhost/call");
            double dbl = mthdimp.getSqrt(100);
              System.out.println("SQRT: "+dbl);
     }
        catch(Exception ex)
        {
             System.out.println("Erros in Client----- "+ex.toString());
              ex.printStackTrace();
      }
  }
}
