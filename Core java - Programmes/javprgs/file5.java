import java.io.*;
class file5
{
   public static void main(String args[]) throws IOException
   {
      int i;
      FileInputStream fin;
      try
      {
          fin=new FileInputStream(args[0]);
          }
catch(FileNotFoundException e)
{
  System.out.println("file not found");
return;
}
 catch(ArrayIndexOutOfBoundsException e)
{
  System.out.println("usage :show file not found");
return;
}     
do
{
  i=fin.read();
  if(i!=-1)
     System.out.print((char)i);
}while(i!=-1);
fin.close();
}
}
