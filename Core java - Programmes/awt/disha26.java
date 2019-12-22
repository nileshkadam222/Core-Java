import java.awt.*;
import java.awt.event.*;
class disha26 extends Frame implements ActionListener
{
  Panel p=new Panel();
  TextField t=new TextField(10);
  Button b=new Button("OK");
  disha26()
  {
    setSize(300,300);
    p.add(t);    
    p.add(b);  
    add(p);
    b.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    p.setBackground(Color.red);
    System.out.println("My name is "+t.getText());
  }
  public static void main(String ar[])
  {
     disha26 d=new disha26();
     d.setVisible(true);
   }
}