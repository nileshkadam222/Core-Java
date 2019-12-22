import java.io.*;
import java.net.*;

class SocketDemo
{
    public static void main(String args[])
    {
        try
        {
            String server = args[0];
            int port = Integer.parseInt(args[1]);

            Socket s = new Socket(server,port);

            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int i = dis.readInt();
            System.out.println(i);

            s.close();
        }
        catch(Exception e)
        {
            System.out.println("Excpetion: " + e);
        }
    }
}
