import java.io.*;
class disha3
{
    public static void main(String ar[])throws IOException
    {
       int a, b;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter nos");
      a=Integer.parseInt(in.readLine());
      b=Integer.parseInt(in.readLine());
      if(a>b)
      {
            System.out.println("Greater number is" +a);
      }
      else
        {
            System.out.println("Greater number is" +b);
      }
     }
}