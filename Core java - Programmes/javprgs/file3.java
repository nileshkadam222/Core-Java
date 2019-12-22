import java.io.*;
public class file3 {
public static void main(String args[])throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String str[]=new String[100];
	System.out.println("enter lines of text");
	System.out.println("enterstop to quit");
	for(int i=0;i<100;i++)
{
	str[i]=br.readLine();
	if(str[i].equals("stop"))
	break;
	
}
System.out.println("here is your file");
for(int i=0;i<100;i++){
if (str[i].equals("stop"))break;
System.out.println(str[i]);
}
}
}
