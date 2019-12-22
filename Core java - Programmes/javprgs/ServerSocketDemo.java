import java.io.*;
import java.net.*;
import java.util.*;

class ServerSocketDemo{
   public static void main(String args[])
   {
      try{
      int port = Integer.parseInt(args[0]);
     Random random = new Random();
    ServerSocket ss = new ServerSocket(port);
   while(true){
        Socket s = ss.accept();
       //write a result to client
      OutputStream os = s.getOutputStream();
     DataOutputStream dos = new DataOutputStream(os);
    dos.writeInt(random.nextInt());
    s.close();
   }
} catch(Exception e) 
  {
    System.out.println("Exception:" +e);
   }
}
}