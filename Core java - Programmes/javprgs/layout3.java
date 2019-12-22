import java.awt.*;
import java.applet.*;
//<applet code="layout3.class" width=600 height = 600></applet>
public class layout3 extends Applet
{
   public void init()
    {
      setLayout(new GridLayout(2,3));
      add(new Button("RED"));
      add(new Button("BLUE"));
      add(new Button("GREEN"));
      add(new Button("YELLOW"));
      add(new Button("PURPLE"));
      add(new Button("BLACK"));
     }
}
