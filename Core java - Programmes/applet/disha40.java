import java.applet.*;
import java.awt.*;
/*<applet code="applet6.class" height = 200 width=400>
<param name = "Name" value = "john">
<param name = "age" value="18">
</applet>
*/
 
public class disha40 extends Applet
{
  String n,a;
  public void init()
   {
     n=getParameter("name");
     if(n==null)
      n = " ";
      a=getParameter("age");
   }
public void paint(Graphics g)
  {
   g.drawString(n +" is a student pursuing graduation in engineering. ",20,20);
   g.drawString(n +" is  " + a + "years old",20,60);
   }
}
