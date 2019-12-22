import java.io.*;
class suraj1
{
 public static void main(String arg[])throws IOException
 {
  float a,b,c=0;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter the 1st number");
  a=Float.parseFloat(in.readLine());
  System.out.println("enter the 2nd number");
  b=Float.parseFloat(in.readLine());
  c=a+b;
  System.out.println("the sum is = " +c);
 }
} 