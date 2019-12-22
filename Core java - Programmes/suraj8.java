import java.io.*;
class suraj8
{
 public static void main(String args[])throws IOException
 {
  int i,b,c;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("ENTER THE NUMBER");
  b=Integer.parseInt(in.readLine()); 
  for(i=1;i<=10;i++)
  {
   c=b*i;
  
     System.out.println(b+"*"+i+"="+c);
  }
 }
}