import java.io.*;
class suraj2
{
 public static void main(String arg[])throws IOException
 {
  int p,r,t,i=0;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter the principal amount");
  p=Integer.parseInt(in.readLine());
  System.out.println("enter the rate of interest");
  r=Integer.parseInt(in.readLine());
  System.out.println("enter the time");
  t=Integer.parseInt(in.readLine());
  i=(p*r*t)/100;
  System.out.println("the simple interest is = " +i);
 }
} 