import java.awt.*;
class test extends Frame
{
Panel p=new Panel();
Label r=new Label("enter no:");
TextField t1=new TextField(10);
Button b =new Button("red");
Checkbox c=new Checkbox("swim");
test()
{
setSize(300,300);
p.setBackground(Color.pink);
t1.setBackground(Color.red);
setTitle("akanksha");
p.add(r);
p.add(t1);
p.add(c);
p.add(b);
add(p);
}
public static void main(String arg[])
{
test t=new test();
t.setVisible(true);
}
}
