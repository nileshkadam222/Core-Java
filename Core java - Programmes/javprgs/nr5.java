import java.awt.*;
import javax.swing.*;
class nr5 extends JFrame
{
JPanel p=new JPanel();
JButton b=new JButton("red");
Button r=new Button("green");
JCheckBox c=new JCheckBox("female");
nr5()
{
setSize(200,200);
p.add(b);
p.add(r);
p.add(c);
add(p);
}
public static void main(String ar[])
{
nr5 n=new nr5();
n.setVisible(true);
}
}