import java.io.*;
class disha5
{
   public static void main(String ar[])throws IOException
   {
       String s;
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the Gender");
       s = in.readLine();
        if(s=="m")
       {
	   System.out.println("Hello Mr.XYZ");
       }
       else
       {
	   System.out.println("Hello Ms.XYZ");
       }
    }
}
       