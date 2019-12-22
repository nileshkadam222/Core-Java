import java.applet.*;
import java.awt.*;
//<Applet code="label1.class"   height=1000 width=500></applet>
public class label1 extends Applet
{
    public void init()
   {
          Label l1=new Label("one");
          TextField t1=new TextField();
          List L1=new List();
          Label l2=new Label("two");
          TextField t2=new TextField();
          Label l3=new Label("three");
          TextArea t3=new TextArea();
          Button b1=new Button("button1") ;                                     Button b2=new Button("button2") ;                                     Button b3=new Button("button3") ;    
          add(l1);
          add(L1);
          add(t1);  
          add(l2);
          add(t2);
          add(l3);
          add(t3);
          add(b1);
          add(b2);
          add(b3);
   }
}
