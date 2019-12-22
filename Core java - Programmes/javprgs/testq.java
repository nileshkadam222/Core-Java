import javax.swing.*;
class testq extends JFrame
{
JPanel p=new JPanel();
JButton b=new JButton("red");
JButton c=new JButton("green");
JLabel l=new JLabel("enter no:");
JTextField t1=new JTextField(20);
testq()
{
setSize(300,300);
p.add(l);
p.add(b);
p.add(c);
add(p);
}
public static void main(String ar[])
{
testq t=new testq();
t.setVisible(true);
}
}
