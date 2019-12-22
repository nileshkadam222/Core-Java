import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class rna extends Frame implements ActionListener
{
JComboBox c;
JRadioButton b=new JRadioButton("red");
Panel p=new Panel();
rna()
{
setSize(300,300);
String s[]={"os","cg","oops"};
c=new JComboBox();
for(int i=0;i<=2;i++)
c.addItem(s[i]);
p.add(c);
p.add(b);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(b.isSelected())
p.setBackground(Color.red);
}
public static void main(String ar[])
{
rna n=new rna();
n.setVisible(true);
}
}