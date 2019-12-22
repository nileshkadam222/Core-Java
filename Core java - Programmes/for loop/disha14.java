import java.io.*;
class disha14
{
   public static void main(String ar[])throws IOException
   {
       int i,n, sum=0;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter value of n");
        for(i=1;i<=5;i++)
	{
                                 n=Integer.parseInt(in.readLine());
                                  sum=n+sum;
	
	}
        
	System.out.println("The summation is "+sum);
   }
}
