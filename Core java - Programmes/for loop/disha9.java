import java.io.*;
class disha9
{
   public static void main(String ar[])throws IOException
   {
       int i, sum=0;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       for(i=1;i<=10;i++)
	{
	 sum=sum+i;
	}
	System.out.println("The summation is "+sum);
   }
}
