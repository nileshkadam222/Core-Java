import java.awt.*;
import java.awt.event.*;
  class suraj12 extends Frame implements ActionListener
   {
     Panel a=new Panel();
     Button n=new Button("ok");
     Button n1=new Button("cancel");
     TextField i=new TextField(60);
     Label p =new Label(",sggscjgcjdg");
     suraj12()
        {
          setSize(300,300);
          a.add(i);
          a.add(n);
          a.add(n1);
          add(a);
          
          n.addActionListener(this);
          n1.addActionListener(this);
          a.add(p);
         }
     public void actionPerformed(ActionEvent e)
         {
           String k=e.getActionCommand();
           if(k.equals("ok"))
           {
            a.setBackground(Color.red);
            }
            else
            {
             a.setBackground(Color.blue);
             }
           }
     public static void main(String nil[])
           {
              suraj12 ni = new suraj12();
              ni.setVisible(true);
            }
         }
          