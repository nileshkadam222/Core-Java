import java.io.*;
class file2
{
    public static void main(String args[]) throws IOException
    {
      String str;
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter lines of text:");
System.out.println("enter stop to quit");

do
{
   str=br.readLine();
   System.out.println(str);
}while(!str.equals("stop"));
}
}