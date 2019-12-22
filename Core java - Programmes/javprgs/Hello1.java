import java.rmi.*;
import java.rmi.server.*;

public class Hello1 extends UnicastRemoteObject 
  implements HelloInterface1 {
  private String message;
  public Hello1 (String msg) throws RemoteException {
  message = msg;
  }
  public String say() throws RemoteException {
  return message;
  }
  public java.util.Date getDate()
  {
       return new java.util.Date();
   }

}