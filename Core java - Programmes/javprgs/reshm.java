import java.awt.*;
import java.awt.event.*;
class reshm extends Frame implements itemListener
{
Checkbox c=new Checkbox("red");
Panel p=new Panel();
reshm()
{
setSize(300,300);
p.add(c);
add(p);
c.additemListener(this);
}
public Static itemStateChanged(itemEvent e)
{
p.setBackground(Color.red);
}
Public Static void main(String ar[])
{
reshm n=new reshm();
n.setVisible(true);
}
}