import java.io.*;
class stud
{
public static void main(String ar[])throws Exception
{
int f=1,i,n;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter no:");
n=Integer.parseInt(br.readLine());
for(i=1;i<=n;i++)
{
f=f*i;
}
System.out.println("factorial="+f);
}
} 

               
