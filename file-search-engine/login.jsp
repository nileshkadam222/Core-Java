<%@page import="java.sql.*"%>
<html>
<head>
<link rel=stylesheet type="text/css" href="style.css">
<center>
<table width=95% height=3% border=0 cellspacing=0>
<tr>
<td bgcolor="#fa6600" width=100% height=3%>
</td>
</tr>
</table>
</center>
</head>
<body bgcolor="#56b4c9"><center><br><br><br><font size=6 color=black>

<%
		try
		{
			String t1=request.getParameter("t1");
			String t2=request.getParameter("t2");
			String pass="";
			String p1="";
			Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri","root","");
PreparedStatement ps=con.prepareStatement("select * from register where uid=?");
			ps.setString(1,t1);
			ResultSet rs=ps.executeQuery();
			int flag=0;
		while(rs.next())
		{       	p1=rs.getString(1);
			pass=rs.getString(4);
			if(pass.equals(t2))
			{
				flag=1;
			}
			else
			{
				flag=0;	
			}
		}
		if(flag==1)
		{ 	
			out.print("Hai ");
			out.print(p1); 
			if(p1.equals("srikanth"))
			{
%><a href="middle1.html" target=middle><font color="#ffffff" size=5>Homepage</a><%
			}
			else
			{
%>
<a href="middle.html" target=middle><font color="#ffffff" size=5>Homepage</a>
<%
			}
		}
		else
			%><a href="login.html" target=bottom><font color=black size=5>Login Failed,Click here to Login</a></font><%
		}
	catch(Exception e)
	{out.print(e);
	}
%>
</body>
</html>
