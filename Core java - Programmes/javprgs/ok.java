import java.awt.*;
import java.awt.event.*;
class ok extends Frame
{
ok()
{
setSize(300,300);
repaint();
}
public void paint(Graphics g)
{
g.setColor(Color.red);
g.fillRect(50,50,100,100);
g.setColor(Color.blue);
g.drawLine(50,50,60,160);
g.setColor(Color.pink);
g.fillOval(50,60,60,100);
}
public static void main(String ar[])
{
ok n=new ok();
n.setVisible(true);
}
}