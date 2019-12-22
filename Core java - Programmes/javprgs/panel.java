import  java.awt.*;
import javax.swing.*;
public class panel extends JApplet
{

JPanel jp,jp12 ;
JScrollPane jp1,jp123;
JSplitPane jsp2;
Container cp;
public void init()
{
jp=new JPanel();
jp.setLayout(new GridLayout(14,15));
for(int i=1; i<=6*5; i++)
{
jp.add(new JButton("button"+i));
}
cp=getContentPane();
jp1=new JScrollPane(jp ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);



jp12=new JPanel();
jp12.setLayout(new GridLayout(14,15));
for(int i=1; i<=5*6; i++)
{
jp12.add(new JButton("button"+i));
}
jp123=new JScrollPane(jp12 ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);



jsp2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp123);
cp.add(jsp2);
} 


}
//<applet code=panel width=900 height=900> </applet>
