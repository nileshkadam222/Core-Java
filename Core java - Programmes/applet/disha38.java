import java.awt.*;
import java.applet.*;
/*
<applet code="applet2.class" width=600 height=400 hspace=300  vspace=200 > </applet> 
*/
public class disha38 extends Applet
{
   String msg;
   public void init()
   {
       setBackground(Color.cyan);
       setForeground(Color.red);
       msg="inside init()--";
    }

   public void start()
   {
        msg+="inside start( )--";
   }

  public void paint(Graphics g)
  {
     msg +="inside paint()";
     g.drawString(msg,10,30);
  }
} 