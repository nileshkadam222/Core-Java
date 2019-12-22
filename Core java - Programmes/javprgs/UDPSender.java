//java UDPSender  127.0.0.1  8080 hello
import java.net.*;

class UDPSender
{
    public static void main(String args[])
    {
        try
        {
           
            InetAddress ia = InetAddress.getByName(args[0]);
             int port = Integer.parseInt(args[1]);
             DatagramSocket ds = new DatagramSocket();
            byte buffer[] = args[2].getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length,ia,port);
            ds.send(dp);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
