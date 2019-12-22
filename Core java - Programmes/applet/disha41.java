import java.awt.*;
import java.applet.*;

public class disha41 extends Applet
{
public void paint(Graphics g)
{
Font f = new Font ("Arial",Font.ITALIC,20);
g.setFont(f);
g.drawString("keeep smiling",80,60);
g.drawOval(60,60,200,200);
g.fillOval(90,120,50,20);
g.fillOval(190,120,50,20);
g.drawLine(165,125,165,170);
g.drawArc(110,130,95,95,0,-180);
}
}
/*
<applet CODE="applet7" height=300 width=300>
</applet>
*/