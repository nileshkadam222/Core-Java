import java.io.*;
class nr6
{
public static void main(String ar[])throws Exception
{
int i;
int[] a=new int[2];
int[] b=new int[2];
int[] c=new int[2];
BufferedReader br=new BufferedReader
(new InputStreamReader(System.in));
System.out.println("enter nos:");
for(i=0;i<2;i++)
{
a[i]=Integer.parseInt(br.readLine());
b[i]=Integer.parseInt(br.readLine());
}
System.out.println("nos are");
for(i=0;i<2;i++)
{
c[i]=a[i]+b[i];
System.out.println(c[i]);
}
}
}