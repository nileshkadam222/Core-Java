import java.io.*;
import java.net.*;

class URLDemo
{
    public static void main(String args[])
    {
         try
         { 
              URL url  = new URL(args[0]);
               InputStream	is = url.openStream();
               byte buffer[] = new byte[1024];
               int i;
               while((i = is.read(buffer)) != -1)
               {
	System.out.write(buffer,0,i);
                }
            }
           catch(Exception e)
           {
	e.printStackTrace();
           }
    }
}			   	 		 	