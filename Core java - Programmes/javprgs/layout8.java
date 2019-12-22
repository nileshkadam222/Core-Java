import java.awt.*;
// import java.applet.*;
import javax.swing.*;
 
public class layout8 extends JFrame {
 
  public static void main(String[] args) {
      layout8 frame = new layout8();
      frame.doSomething();
  }
 
  void doSomething() {
    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    c.add(new JButton("One"),   BorderLayout.NORTH);
    c.add(new JButton("Two"),   BorderLayout.WEST);
    c.add(new JButton("Three"), BorderLayout.CENTER);
    c.add(new JButton("Four"),  BorderLayout.EAST);
    c.add(new JButton("Five"),  BorderLayout.SOUTH);
    c.add(new JButton("Six"),   BorderLayout.SOUTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
  }
}
