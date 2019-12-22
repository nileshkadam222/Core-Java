import java.awt.*;
import java.applet.*;
//<applet code="layout2.class" width=600 height = 300></applet>
public class layout2 extends Applet
{
   public void init()
    {
      setLayout(new BorderLayout());
      Button b,c,d,e;
      //a=new Button("ADD");
      b=new Button("UPDATE");
      c=new Button("RESET");
      d=new Button("DELETE");
      e=new Button("CANCEL");
      add(new Button("ADD"),BorderLayout.EAST);
      add(b,BorderLayout.WEST);
      add(c,BorderLayout.SOUTH);
      add(d,BorderLayout.NORTH);
      //add(e,BorderLayout.CENTER);
     }
}
