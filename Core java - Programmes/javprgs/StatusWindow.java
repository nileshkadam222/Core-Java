import java.awt.*;
import java.applet.*;


/*<APPLET code = StatusWindow HEIGHT = 400 WIDTH = 350></applet>*/

public class StatusWindow extends Applet
{
  public void init()
  {
  setBackground(Color.black);
  }
 
//Display msg in applet window.

public void paint(Graphics g)
  {
   g.drawString("This is in the applet window.",10,20);
showStatus("This is shown in statue window.");
  }
}