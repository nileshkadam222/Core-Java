import java.io.*;
class oddeven
{
public static void main(String ar[])throws Exception
{
int f=1,i,n;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter no:");
n=Integer.parseInt(br.readLine());
if(n%2==0)
{
      System.out.println("even:"+n);
}
else
{
    System.out.println("odd:" +n);
}
}
}