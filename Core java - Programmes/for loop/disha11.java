import java.io.*;
class disha11
{
   public static void main(String ar[])throws IOException
   {
       int i,n;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter value for n");
       n=Integer.parseInt(in.readLine());
       for(i=1;i<=n;i++)
	{
	 System.out.println(+i);
	}
	//System.out.println("The summation is "+sum);
   }
}