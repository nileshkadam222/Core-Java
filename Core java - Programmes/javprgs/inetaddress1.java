import java.net.*;
class inetaddress1
{
   public static void main(String args[]) throws UnknownHostException
   {
     InetAddress add=InetAddress.getLocalHost();
     System.out.println(add);
   }
}