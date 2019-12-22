/***********with out using third variable*****************/
import java.io.*;
class suraj4
{
 public static void main(String arg[])throws IOException
 {
  int a,b;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter the 1st number");
  a=Integer.parseInt(in.readLine());
  System.out.println("enter the 2nd number");
  b=Integer.parseInt(in.readLine());
  a=a+b;
  b=a-b;
  a=a-b; 
  System.out.println("the value of a is = " +a);
  System.out.println("the value of b is = " +b);
 }
} 