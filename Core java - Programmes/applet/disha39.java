import javax.swing.*;
import java.awt.*;
import  java.applet.*;
/*
<applet code="applet4.class" width=300  height=500> </applet> 
*/

public class disha39 extends JApplet
{
    int initctr=0;
    int startctr=0;
    int stopctr=0;
    int destroyctr=0;
    public void init()
    {
       initctr++;
       repaint();
    }    
   public void start()
    {
       startctr++;
       repaint();
    }

    public void stop()
    {
       stopctr++;
       repaint();
    }
    public void destroy()
    {
       destroyctr++;
       repaint();
       System.out.println("hello ! its destroyed:" + String.valueOf(destroyctr++));
    }
    public void paint(Graphics g)
    {
        g.drawString("init has been invoked:" + String.valueOf(initctr)  + "times",20,20);
        g.drawString("start has been invoked:" + String.valueOf(startctr)  + "times",20,40);
        g.drawString("stop has been invoked:" + String.valueOf(stopctr)  + "times",20,50);
        g.drawString("destroy has been invoked:" + String.valueOf(destroyctr)  + "times",20,60);
    }
}