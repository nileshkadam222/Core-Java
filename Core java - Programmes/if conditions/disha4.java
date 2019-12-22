import java.io.*;
class disha4
{
   public static void main(String ar[])throws IOException
    {
       int a;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the age");
       a=Integer.parseInt(in.readLine());
       if(a>=18)
       {
           System.out.println("You are eligible for voting");
        }
       else
        {
	   System.out.println("You are not eligible for voting");
         }
     }
}