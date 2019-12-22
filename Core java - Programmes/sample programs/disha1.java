import java.io.*;
class disha1
{
   public static void main(String ar[])throws IOException
   {
      int a, b, c=0;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter the first nnumber");
     a=Integer.parseInt(in.readLine());
     System.out.println("Enter the second nnumber");
     b=Integer.parseInt(in.readLine());
     c=a+b;
     System.out.println("The sum is "+c);
   }
}