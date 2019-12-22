import java.rmi.*; 
public interface HelloInterface1 extends Remote {
  public String say() throws RemoteException;
  public java.util.Date getDate() throws java.rmi.RemoteException;
}
