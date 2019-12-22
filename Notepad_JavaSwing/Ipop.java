package notepad;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Ipop {
	
public static void main(String[] args) throws Exception{
		
		FileOutputStream dout=new FileOutputStream("D:\\new\\amaan.txt");
		
		FileInputStream fis=new FileInputStream("d:\\new\\fout.txt");
		int data;
		data=fis.read();
		while((data!=-1))
				{	
					dout.write((char)data);
				}
		dout.close();
		fis.close();

}
}
