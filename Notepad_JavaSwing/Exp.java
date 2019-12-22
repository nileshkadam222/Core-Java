package notepad;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Component.*;

public class Exp implements ActionListener {
	int count=0;
	JFrame f1,f2;
	JButton b,b1;
	
	Exp(){
		f1=new JFrame("ONE");
		f2=new JFrame("TWO");
		f1.setSize(400, 400);
		f2.setSize(400, 400);
		f1.setLayout(null);
		f2.setLayout(null);
		
		
		b=new JButton("CLICK");
		b.setBounds(50, 50, 100, 60);
		
		b1=new JButton("CLICK");
		b1.setBounds(50, 50, 100, 60);
		
		f1.add(b);
		f2.add(b1);
		
		/*if(count==0){
			f1.setVisible(true);
			f2.setVisible(false);
				}
		else
			{
			f2.setVisible(true);
			f1.setVisible(false);
			}*/
		
		
		f1.setVisible(true);
		//f2.setVisible(true);
		
		
		b.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b){
			f1.setVisible(false);
			f2.setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new Exp();
	}
	
	

}
