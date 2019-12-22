import java.io.*;
class filemethods1
{
   public static void main(String args[])
   {
       File f1=new File("d:\\surekha","abc.txt");
       System.out.println("file name: " + f1.getName());
       System.out.println("file path: " + f1.getPath());
      System.out.println("file absolutepath: " + f1.getAbsolutePath());
      System.out.println(f1.exists() ? "file not exists"  : "file  exist");
      System.out.println(f1.isDirectory() ? "file is a directory " : "file is not a directory");
      System.out.println(f1.isFile() ? "file is an ordinary file " : " file is not an ordinary file");
      if(f1.canRead())
      {
       System.out.println("v can read from this file:");
   
      }
      else
      {
           System.out.println("v cant read from this file:");
      }
      if(f1.canWrite())
      {
          System.out.println("v can write into this file:");
      }
      else
      {          System.out.println("v cant write into this file");
       }
       System.out.println("system was last modified on:"+ f1.lastModified() + "seconds after january 1 1970");
}
}