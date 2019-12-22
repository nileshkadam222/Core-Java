import java.net.*;

class testUDP
{
    public static void main(String args[])
    {
        String s = "Hello Java!!!";
        byte[ ] data = new byte[s.length()];

        s.getBytes(0,s.length(),data,0);
        try
        {
            InetAddress ia = InetAddress.getByName("localhost");
            int port = 80;

            DatagramPacket dp = new DatagramPacket(data,data.length,ia,port);
            System.out.println("The Packets address is " + dp.getAddress() + " on port " + dp.getPort());
            System.out.println("There are " + dp.getLength() + " byte of data in the packet");
            System.out.println(new String(dp.getData(),0,0,dp.getLength()));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
