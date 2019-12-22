import java.io.*;
class root
{
public static void main(String ar[])throws Exception
{
int s=0,c=0;
int a[]=new int[5];
DataInputStream br=new DataInputStream(System.in);
System.out.println("enter nos1:");
System.out.println("enter nos2:");
for(int i=0;i<5;i++)
{
a[i]=Integer.parseInt(br.readLine());
a[e]=Integer.parseInt(br.readLine());
}
System.out.println("array value are1:");
for(int i=0;i<5;i++)
System.out.println("array value are2:");
for(int i=0;i<5;i++)

{
System.out.println(a[i]);
s=s+a[i];
c=c+a[e];
}
System.out.println("total="+s);
System.out.println("total="+c);
}

}
