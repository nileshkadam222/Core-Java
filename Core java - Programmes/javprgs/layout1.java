import java.awt.*;
import java.applet.*;
//<applet code="layout1.class" width=300 height = 400></applet>
public class layout1 extends Applet
{
   public void init()
    {
      setLayout(new FlowLayout(FlowLayout.RIGHT));
      Button a,b,c;
      a=new Button("ADD");
      b=new Button("UPDATE");
      c=new Button("DELETE");
      add(a);
      add(b);
      add(c);
     }
}
