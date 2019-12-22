import java.io.*;
class disha12
{
   public static void main(String ar[])throws IOException
   {
       int i, n, ans=0;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the value of n");
	n=Integer.parseInt(in.readLine());
       for(i=1;i<=10;i++)
	{
	 ans=n*i;
	System.out.println(+n+"*"+i+"="+ans);
	}
	
   }
}