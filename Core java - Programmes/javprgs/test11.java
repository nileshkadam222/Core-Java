import java.awt.*;
import java.awt.event.*;
class test11 extends Frame implements ActionListener
{
   TextField r;
   Button b,c;
   test11()
  {
     setSize(300,300);
     Panel p=new Panel();
     b=new Button("Enable");
     c=new Button("Disable");
     r=new TextField(10);
     p.add(b);
     p.add(c);
     p.add(r);
     add(p);
    b.addActionListener(this);
    c.addActionListener(this);
  }
public void actionPerformed(ActionEvent e)
{
   String s=e.getActionCommand();
   if(s.equals("Enable"))
   r.setEnabled(true);
   else
  r.setEnabled(false);
 }
public static void main(String ar[])
{
   test11 t=new test11();
   t.setVisible(true);
}
}