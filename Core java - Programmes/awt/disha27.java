import java.awt.*;
import java.awt.event.*;
class disha27 extends Frame implements ActionListener
{
  Panel p=new Panel();
  TextField t1=new TextField(10);  
  TextField t2=new TextField(10);
  TextField t3=new TextField(10);
  Button b=new Button("Work");
  disha27()
  {
    setSize(300,300);
    p.add(b);  
    p.add(t1);
    p.add(t2);    
    p.add(t3);

    add(p);
    b.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    int sum=0;
    sum=Integer.parseInt(t1.getText())+ Integer.parseInt(t2.getText());
    t3.setText("Sum="+sum);
    
  }
  public static void main(String ar[])
  {
     disha27 d=new disha27();
     d.setVisible(true);
   }
}