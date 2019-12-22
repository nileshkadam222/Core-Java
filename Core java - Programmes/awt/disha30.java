import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class disha30 extends JFrame implements ActionListener
{

Panel p=new Panel();
  JButton b1=new JButton("enable");
  JButton b2=new JButton("disable");
  JTextField t=new JTextField(10);
disha30()
{
  setSize(300,300);
  p.setBackground(Color.blue);
  p.add(b1);
  p.add(b2);
  p.add(t);
  add(p);
  b1.addActionListener(this);
  b2.addActionListener(this);
}
public void  actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s.equals("enable"))
{
JOptionPane.showMessageDialog(this,"u clicked on enable");
t.setEnabled(true);
}
else
{
JOptionPane.showMessageDialog(this,"u clicked on disable");
t.setEnabled(false);
}
}
public static void main(String ar[])
{
disha30 d=new disha30();
d.setVisible(true);
}
}