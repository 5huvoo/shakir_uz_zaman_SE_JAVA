<%@ page import="java.sql.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%  Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/ecom";
String user = "root";
String password = "1212";

String sql = "select id from admin";

try {

  Class.forName(driverName);
  con = DriverManager.getConnection(url, user, password);
  ps = con.prepareStatement(sql);
  rs = ps.executeQuery(); 
%>

<form method="post" action="login.jsp">
<center><h2> Login Page</h2></center>
<table border="1" align="center">
<tr>
  <td>Name(shuvo) :</td>
  <td><input type="text" name="name"/></td>
</tr>

<tr>
<td>Password(12345678) :</td>
<td><input type="password" name="password"/></td>
</tr>

<tr>
<td>Select ID</td>
<td><select name="id">
<option value="select">select</option>

<% while(rs.next())
{ 
String id = rs.getString("id");
%>

<option value=<%=id%>><%=id%></option>

<% 
 }
}
catch(SQLException sqe)
{   out.println("home"+sqe); }
%>

  </select>
 </td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="submit"/></td>


</table>
<a align="center" href="welcome">if login failed , please continue here,,  </a>
</form>
</body>
</html>