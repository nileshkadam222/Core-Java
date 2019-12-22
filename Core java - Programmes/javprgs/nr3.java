import java.awt.*;
import java.awt.event.*;
class nr3 extends Frame implements ActionListener
{
int a,c;
TextField t1=new TextField(10);
TextField t2=new TextField(10);
TextField t3=new TextField(10);
Label l1=new Label("enter no:");
Label l2=new Label("enter no:");
Label l3=new Label("result");
Button b=new Button("MULTI");
Panel p=new Panel();
nr3()
{
setTitle("reshma");
setSize(200,250);
p.add(l1);
p.add(t1);
p.add(l2);
p.add(t2);
p.add(b);
p.add(l3);
p.add(t3);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
a=Integer.parseInt(t1.getText());
c=Integer.parseInt(t2.getText());
t3.setText(""+(a*c));
}
public static void main(String ar[])
{
nr3 q=new nr3();
q.setVisible(true);
}
}