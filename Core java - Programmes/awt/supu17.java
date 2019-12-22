import java.awt.*;
import java.awt.event.*;
class supu17 extends Frame implements ActionListener
{
  Panel p=new Panel();
  Button b=new Button("OK");
 supu17()
  {
    setSize(300,300);
    p.add(b);  
    add(p);
    b.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    p.setBackground(Color.red);
  }
  public static void main(String ar[])
  {
     supu17 d=new supu17();
     d.setVisible(true);
   }
}