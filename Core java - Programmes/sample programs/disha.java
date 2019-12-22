import java.io.*;
class disha
{
   public static void main(String ar[])throws IOException
   {
       int p, r, t, i=0;
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

       System.out.println("Enter the principal amount");
      p=Integer.parseInt(in.readLine());
      System.out.println("Enter the rate of interest");
      r=Integer.parseInt(in.readLine());
    System.out.println("Enter the duration");
    t=Integer.parseInt(in.readLine());
    i=(p*r*t)/100;
   System.out.println("The simple interest is"+i);
 }
}