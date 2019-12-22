import java.net.*;

class testINET
{
    public static void main(String args[])
    {
        try
        {
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
