import java.io.*;
class filemethods4
{
   public static void main(String args[])
   {
      File f=new File("c:/queen/temp");
      if(f.mkdir())
      {
          System.out.println("created a directory");
      }
      else
      {
          System.out.println("not created a directory");   
      }
}
}
