import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class nitin extends Frame implements ActionListener
{
JPanel p=new JPanel();
JButton b=new JButton("r");
JButton n=new JButton("r1");
JButton a=new JButton("r2");
nitin()
{
setTitle("res");
setSize(300,300);
p.add(b);
p.add(n);
p.add(a);
b.addActionListener(this);
n.addActionListener(this);
a.addActionListener(this);
add(p);
}
public void actionPerformed(ActionEvent e)
{
String s=e.getActionCommand();
if(s=="r")
{
p.setBackground(Color.red);
}
else if(s=="r1")
{
p.setBackground(Color.blue);
}
else
{
p.setBackground(Color.pink);
}
}
public static void main(String ar[])
{
nitin t=new nitin();
t.setVisible(true);
}
}
