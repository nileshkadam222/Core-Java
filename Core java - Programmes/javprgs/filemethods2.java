import java.io.*;
class filemethods2
{
public static void main(String args[])
{
for(int i=0;i<args.length;i++)
{
File f=new File("c:\\queen",args[i]);
File f1=new File("c:\\queen\renfile.txt");
if(f.exists())
{
System.out.println(f+"exists");
System.out.println("its size is"+f.length()+"bytes");
f.renameTo(f1);
System.out.println("deleting the file"+f);
System.out.println("****************************");
f.delete();
}
else
System.out.println(f+"does not exists");
}
}
}
