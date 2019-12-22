import java.net.*;
class InetAddresstest
{
   public static void main(String args[])  throws UnknownHostException  x	
   {
      InetAddress add=InetAddress.getLocalHost();
      System.out.println(add);
      add=InetAddress.getByName("starwave.com");
      System.out.println(add);
      InetAddress sw[]=InetAddress.getAllByName("www.nbxc.com");
      for(int i=0;i<sw.length;i++)
      {
          System.out.println(sw[i]);
      }


}
}      