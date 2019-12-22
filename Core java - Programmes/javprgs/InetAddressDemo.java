 import java.net.*;

class InetAddressDemo
{
    public static void main(String args[]) throws UnknownHostException
    {
        try
        {
            InetAddress ias[ ] = InetAddress.getAllByName(args[0]);
            for(int i = 0;i < ias.length;i++)
            {
                System.out.println(ias[i].getHostName());
                System.out.println(ias[i].getHostAddress());
                byte bytes[] = ias[i].getAddress();
                System.out.println(bytes.length);
                for(int j = 0;j < bytes.length; j++)
                {
                 
                       System.out.print(".");
                   if(bytes[j] >= 0)
                      
                        System.out.print(bytes[j]);
                    
               }
               System.out.println(" ");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
