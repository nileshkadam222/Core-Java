// java  UDPReciever  8080

import java.net.*;

class UDPReciever
{
    private final static int BUFFER = 20;
    public static void main(String args[])
    {
        try
        {
            int port = Integer.parseInt(args[0]);
            DatagramSocket ds = new DatagramSocket(port);
            byte buffer[] = new byte[BUFFER];
                                                                
            DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
            ds.receive(dp);

            String str = new String(dp.getData());

            System.out.println(str);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
