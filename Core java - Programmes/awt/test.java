import java.awt.*;
import java.awt.event.*;
class test extends Frame implements ActionListener
{
TextField r;
Button b,c;
test()
{
setSize(300,300);
Panel p=new Panel();
 b=new Button("enable");
 c=new Button("disable");
 r=new TextField(10);
p.add(b);
p.add(c);
p.add(r);
add(p);
b.addActionListener(this);
c.addActionListener(this);
}
public void    actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s.equals("enable"))
r.setEnabled(true);
else
r.setEnabled(false);
}
public static void main(String ar[])
{
test t=new test();
t.setVisible(true);
}
}