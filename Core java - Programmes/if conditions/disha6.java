import java.io.*;
class disha6
{
   public static void main(String ar[])throws IOException
   {
       int year;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       System.out.println("Enter the year");
       year=Integer.parseInt(in.readLine());
       if(year%4==0)
       {
	 System.out.println("The entered year is a leap year");
        }
        else
	 {
	   System.out.println("The entered year is not a leap year");
 	 }
   }
}