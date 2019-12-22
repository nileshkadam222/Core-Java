import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class test1 extends Frame 
{
test1()
{
setSize(300,300);
hand h=new hand();
addMouseListener(h);

}
class hand extends MouseAdapter
{
public void mouseClicked(MouseEvent e)
{
System.out.println("mouse clicked");
JOptionPane.showMessageDialog(null,"sucess");
}
}

public static void main(String ar[])
{
test1 t=new test1();
t.setVisible(true);
}
}