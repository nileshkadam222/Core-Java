import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
public class RMIServer extends UnicastRemoteObject implements MethodInter
{
  public RMIServer()throws RemoteException
    {
      System.out.println("The server is instantitiated");
    }
  public double getSqrt(double dbl)
    {
      return Math.sqrt(dbl);
  }
  public static void main(String args[])
    {
      try
      {
          RMIServer server=new RMIServer();
          Naming.rebind("call",server);
      }
      catch(Exception e)
      {
          System.out.println("Error------" +e.toString());
          e.printStackTrace();
      }
  }
  }

