import java.io.*;
class disha16
{
   public static void main(String ar[])throws IOException
   {
       int i,n, sum=0;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter value for n");
       n=Integer.parseInt(in.readLine());
       for(i=1;i<=n;i++)
	{
	 sum=sum+(i*i*i-1);
	}
	System.out.println("The summation is "+sum);
   }
}