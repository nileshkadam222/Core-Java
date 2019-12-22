import java.awt.*;
import java.awt.event.*;
import javax.Swing.*;
class test12 extends Frame implements ActionListener
{
  Panel p=new Panel();
  Butten b=new Button("Enable");
  Button r=new Button("Disable");
  TextField t=new TextField(10);
  test12()
 {
   setSize(300,300);
   setTitle("apa");
   p.setBackground(Color.blue);
   p.add(b);
   p.add(r);
   p.add(t);
   add(p);
  b.addActionListener(this);
  r.addActionListener(this);
}
public static void actionPerformed(ActionEvent e)
{
  String s=ae.getActionCommand();
  if(s.equals("enable"))
  {
     JOptionPane.showMessageDialog(this,"u clicked on  ENABLE");
    t.setEnabled(true);
  }
 else
 {
    JOption.showMessageDialog(null,"u clicked on disable");
e.setEnable(false);
}
}
public static void main(String ar[])
{
  test12 t=new test12();
  t.setVisible(true);
}
}