import java.io.*;
class suraj5
{
 public static void main(String arg[])throws IOException
 {
  int a,b;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter the 1st number");
  a=Integer.parseInt(in.readLine());
  System.out.println("enter the 2nd number");
  b=Integer.parseInt(in.readLine());
  if(a>b)
   {
   
  System.out.println("the a is greater then b");
}
  else
{
     System.out.println("the b is greater then a");
   }
}
} 