import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class om extends Applet implements ActionListener
{
public void init()
{
TextField t1=new TextField(10);
TextField t2=new TextField(10);
Label L1=new Label("Enter No");
Label L2=new Label("Enter No");
Label L3=new Label("Result");
Button b=new Button("Divi");
{
p.add(L1);
p.add(t1);
p.add(L2);
p.add(t2);
p.add(b);
p.add(L3);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
setBackground(color.pink);
}
}
}
