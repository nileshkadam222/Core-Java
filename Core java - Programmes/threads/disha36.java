import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class disha36 extends JApplet implements Runnable, ActionListener
{
    int i;
   JPanel p=new  JPanel();
   Thread th1=null, th2=null;
  JTextField t1,t2;
  JButton b;
public void init()
{
    b=new JButton("OK");
    th1=new Thread(this);
   th2=new Thread(this);
    t1=new JTextField(10);
    t2=new JTextField(10);
    t1.enable(false);
    t2.enable(false);
    p.add(t1);
    p.add(t2);
    p.add(b);
    p.add(p);
    b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
   t1.enable(true);
   t2.enable(true);
   th1.start();
   th2.start();
}
public void run()
{
    for(i=1;i<=100;i++)
   {
      if(Thread.currentThread().equals(th1))
      {
         t1.setText("i="+i);
         try
         {
            Thread.sleep(100);
         }
         catch(Exception e)
          {
             System.out.println("There is som error");
          }
        }
      if(Thread.currentThread().equals(th2))
      {
         t2.setText("i="+i);
         try
         {
            Thread.sleep(100);
         }
         catch(Exception e)
          {
             System.out.println("There is som error");
          }
        }
      }
}
   public static void main(String ar[])
  {
      disha36 d=new disha36();
      d.setVisible(true);
}
}