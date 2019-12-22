import java.io.*;
class lily
{
public static void main (String arg[])
{
int a, b, c=0;
try{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
a=Integer.parseInt(br.readLine());
b=Integer.parseInt(br.readLine());
}
catch(Exception e)
{
System.out.println("cannot divide");
}
System.out.println("c="+c);
}
}