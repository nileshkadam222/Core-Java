import java.awt.*;
import java.awt.event.*;
class disha29 extends Frame implements ActionListener
{
  Panel p=new Panel();
  Label l1=new Label("name");
  Label l2=new Label("address");
  Label l3=new Label("dob");
  Label l4=new Label("age");
  TextField t1=new TextField(10);  
  TextField t2=new TextField(10);  
  TextField t3=new TextField(10);
  TextField t4=new TextField(10);
  Button b=new Button("Submit");
   
   disha29()   
  {
    setSize(300,300);
    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(t3);
    p.add(l4);
    p.add(t4); 
    p.add(b);  
    add(p);
    b.addActionListener(this);
   }
  
  public void actionPerformed(ActionEvent e)
  {
    p.setBackground(Color.red);
    System.out.println("Your Name is "+(t1.getText()));
    System.out.println("Your Address is "+(t2.getText()));
   System.out.println("Your dob is "+(t3.getText()));
   System.out.println("Your age is "+(t4.getText()));  
  }
  public static void main(String ar[])
  {
     disha29 d=new disha29();
     d.setVisible(true);

   }
}