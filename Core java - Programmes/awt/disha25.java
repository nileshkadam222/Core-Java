import java.awt.*;
import java.awt.event.*;
class disha25 extends Frame implements ActionListener
{
  Panel p=new Panel();
  Button b=new Button("OK");
  disha25()
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
     disha25 d=new disha25();
     d.setVisible(true);
   }
}