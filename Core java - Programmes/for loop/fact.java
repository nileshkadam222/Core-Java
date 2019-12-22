import java.io.*;
class fact
{
   public static void main(String ar[])throws IOException
   {
       int i,n, fact=1;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter value for n");
       n=Integer.parseInt(in.readLine());
       for(i=1;i<=n;i++)
	{
	    fact=fact*i;
	}
	System.out.println("The factorial is "+fact);
   }
}
