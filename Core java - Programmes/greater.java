import java.io.*;
class greater
{
 public static void main(String arg[])throws IOException
{
 int a,b,c;
 BufferedReader in=new BufferedReader(new  InputStreamReader(System.in));
 System.out.println("enter the 1st number");
 a=Integer.parseInt(in.readLine());
 System.out.println("enter the 2nd number");
 b=Integer.parseInt(in.readLine());
 System.out.println("enter the 3rd number");
 c=Integer.parseInt(in.readLine());
 if(a>b)
 {
  System.out.println(" A is greater then B");
 }
 else if(b>c)
 {
  System.out.println("B is greater then c");
 }
 else if(c>a)
 {
  System.out.println(" c is greater then a and b");
 }
}
}
   
