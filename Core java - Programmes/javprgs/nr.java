import java.awt.*;
import java.awt.event.*;
class nr extends Frame implements ActionListener
{
Panel p=new Panel();
TextField t1=new TextField(10);
TextField t2=new TextField(10);
Button b=new Button("ok");
nr()
{
setSize(300,300);
p.add(b);
p.add(t1);
p.add(t2);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
p.setBackground(Color.red);
t1.setBackground(Color.blue);
t2.setText(t1.getText());
}
public static void main(String ar[])
{
nr n=new nr();
n.setVisible(true);
}
}