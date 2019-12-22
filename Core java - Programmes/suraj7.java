import java.io.*;
class suraj7
{
 public static void main(String args[])throws IOException
 {
  int i,n,fact=1;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("ENTER THE NUMBER");
  n=Integer.parseInt(in.readLine()); 
  for(i=1;i<=n;i++)
  {
   fact=fact*i;
  }
     System.out.println("the factorial is="+fact);
 }
}