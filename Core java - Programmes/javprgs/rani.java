import java.awt.*;
import java.awt.event.*;
class rani extends Frame implements ActionListener
{
int a,c;
TextField t1=new TextField(10);
TextField t2=new TextField(10);
TextField t3=new TextField(10);
Label L1=new Label("Enter No");
Label L2=new Label("Enter No");
Label L3=new Label("Result");
Button b=new Button("Sub");
Panel p=new Panel();
rani()
{
setTitle("rani");
setSize(150,200);
p.add(L1);
p.add(t1);
p.add(L2);
p.add(t2);
p.add(b);
p.add(L3);
p.add(t3);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
a=Integer.parseInt(t1.getText());
c=Integer.parseInt(t2.getText());
t3.setText(""+(a-c));
}
public static void main(String ar[])
{
rani q=new rani();
q.setVisible(true);
}
}