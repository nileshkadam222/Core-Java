import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class nad extends Frame implements ActionListener
{
Connection con;
Button b=new Button("insert");
Panel p=new Panel();
nad()
{
setSize(300,300);
p.add(b);
add(p);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
String s="insert into stud values(1,'deepak',10000)";
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:abc");
Statement st=con.createStatement();
int i=st.executeUpdate(s);
JOptionPane.showMessageDialog(null,"Record inserted");
}
public static void main(String ar[])
{
nad t=new nad();
t.setVisible(true);
}
}