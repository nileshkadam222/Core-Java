import java.rmi.*;
public interface MethodInter extends Remote
{
 double getSqrt(double dbl)throws RemoteException;
}



