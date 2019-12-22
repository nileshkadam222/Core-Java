<html>	
<head>
<link rel=stylesheet type="text/css" href="style.css">
<center>
<table width=95% height=3% border=0 cellspacing=0>
<tr>
<td bgcolor="#fa6600" width=100% height=3%></td>
</tr>
</table>
</center>
</head> 
 <body bgcolor="#56b4c9"><center><br><br><br>
<font size=5 color=black>
<%@page import="java.sql.*"%>
<%
			try
			{
				String nm=request.getParameter("nm");
				String gen=request.getParameter("gen");
				String uid=request.getParameter("uid");
				String pass=request.getParameter("pass");
				String eid=request.getParameter("eid");
				Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri","root","");
PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
				ps.setString(1,nm);
				ps.setString(2,uid);
				ps.setString(3,gen);
				ps.setString(4,pass);
				ps.setString(5,eid);
				int rs=ps.executeUpdate();
				if(rs>0)
				{
					out.print("Registration succesful");
					%>  
					 <br>Now you can Login
					<%
				}
				else
				{
					out.print("Registration failed");
					%>  	
					 <br>Specified userid is already in use.
					<br><a href="registration.html">Register again</center> 
					<%
				}
		}
		catch(Exception e)
		{
			%>  	
					 <br>Specified userid is already in use or
					 <%
			out.println(e.getMessage());
			%>
			<br><a href="registration.html">Register again</center>
			<%
		}
%>

