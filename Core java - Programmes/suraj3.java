import java.io.*;
class suraj3
{
 public static void main(String arg[])throws IOException
 {
  int a,b,c;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter the 1st number");
  a=Integer.parseInt(in.readLine());
  System.out.println("enter the 2nd number");
  b=Integer.parseInt(in.readLine());
  c=a;
  a=b;
  b=c;
  System.out.println("the value of a is = " +a);
  System.out.println("the value of b is = " +b);
 }
} 