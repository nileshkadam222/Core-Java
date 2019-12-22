import java.awt.*;
import java.awt.event.*;
class suraj10 extends Frame implements ActionListener
{
  Panel p=new Panel();
  Button b1=new Button("green");
  Button b2=new Button("yellow");
  suraj10()
  {
    setSize(300,300);
    p.add(b1);
    p.add(b2);  
    add(p);
    b1.addActionListener(this);
    b2.addActionListener(this);
  }
public void actionPerformed(ActionEvent e)
  {
   string s=e.getActionCommand();
    if(s.equals("green")
   {    
    p.setBackground(Color.green);
  }
else
{
      p.setBackground(Color.yellow);
}
    
public static void main(String arg[])
  {
     suraj10 d=new suraj10();
     d.setVisible(true);
   }
}