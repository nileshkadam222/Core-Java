package notepad;




import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.*;
public class Notepad implements ActionListener {
	JMenuBar mb;
	JMenu file,edit,help;
	JTextArea ta;
	JFrame f,f1;
	JMenuItem cut,copy,paste,open,selectall,openfile,save,saveas,exit;
	JDialog jb;
	JOptionPane jo;
	int count=0;
	 
	
	Notepad(){
		f=new JFrame("NOTEPAD");
		f.setSize(400,400);
		f1=new JFrame("ONE");
		f1.setSize(400, 400);
		
		
		
		file=new JMenu("FILE");
		file.setBounds(50, 5, 50, 20);
		help=new JMenu("HELP");
		help.setBounds(170, 5, 50, 20);
		edit=new JMenu("EDIT");
		edit.setBounds(110, 5, 50, 20);
		
		cut=new JMenuItem("CUT");
		copy=new JMenuItem("COPY");
		paste=new JMenuItem("PASTE");
		selectall=new JMenuItem("SELECT ALL");
		
		openfile=new JMenuItem("OPEN FILE");
		save=new JMenuItem("SAVE");
		saveas=new JMenuItem("SAVE AS");
		exit=new JMenuItem("EXIT");
		//cut=new JMenuItem("CUT");
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		
		file.add(openfile);
		file.add(save);
		file.add(saveas);
		file.add(exit);
		JFileChooser jf=new JFileChooser();
		jf.setBounds(80, 5, 60, 20);
		
		mb=new JMenuBar();
		mb.setBounds(5, 5, 400, 20);
		
		
		ta=new JTextArea();
		ta.setBounds(5, 30, 400, 350);
		
		f.add(mb);
		f.add(ta);
		mb.add(file);
		mb.add(edit);
		mb.add(help);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectall);
		edit.add(copy);
		f.setLayout(null);
		f1.setLayout(null);
		if(count==0){f.setVisible(true);}
		else{f1.setVisible(true);}
	
		
		edit.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		save.addActionListener(this);
		saveas.addActionListener(this);
		exit.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==cut)
			{
				ta.cut();
			}
			else if(e.getSource()==copy)
			{
				ta.copy();
			}
			else if(e.getSource()==selectall)
			{
				ta.selectAll();
			}
			else if(e.getSource()==paste)
			{
				ta.paste();
			}
			else if(e.getSource()==save){
				/*try{save1();}
				catch(Exception ex){
					System.out.println("File not found");
				}*/
				count=1;
			}
				
			
			
		}
		
	
	public static void main(String[] args) {
		new Notepad();
	}
	
	
	
public void save1()throws Exception{
	/*//Ipop ip=new Ipop();
	
		FileInputStream fis=new FileInputStream(ta.getText());
	
		FileOutputStream dout=new FileOutputStream("d:\\new\\fout.txt");
	
	int data=fis.read();
	while((data!=-1))
			{	
				dout.write((char)data);
			}
	dout.close();
	fis.close();*/
	FileWriter fw=new FileWriter("d:\\new\\fout.txt");
	//Scanner sc=new Scanner(System.in);
	
	String s=ta.getText();
	fw.write(s);
	fw.flush();
	
}

	



}
	

	



