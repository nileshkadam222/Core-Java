import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class hd extends Frame implements ActionListener
{
Panel p=new Panel();
Button b=new Button("show");
hd()
{
setSize(300,300);
p.add(b);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{

try
{
String s="insert into stud(rno,sname) values(4,'rajesh')";
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:abc");
Statement st=con.createStatement();
int i=st.executeUpdate(s);
System.out.println(i+"record inserted");
}catch(Exception ae){ae.printStackTrace();}



}
public static void main(String ar[])
{
hd t=new hd();
t.setVisible(true);
}
}