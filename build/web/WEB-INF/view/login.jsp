<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

</head>

<body>

   <%! String userdbName;
String userdbPsw;
String dbUsertype;

%>

<%

Connection con= null;

PreparedStatement ps = null;

ResultSet rs = null;



String driverName = "com.mysql.jdbc.Driver";

String url = "jdbc:mysql://localhost:3306/ecom";

String user = "root";

String dbpsw = "1212";


String sql = "select * from admin where name=? and password=?";

String name = request.getParameter("name");

String password = request.getParameter("password");




if((!(name.equals(null) || name.equals("")) && !(password.equals(null) || 
password.equals(""))))

{

try{

Class.forName(driverName);

con = DriverManager.getConnection(url, user, dbpsw);

ps = con.prepareStatement(sql);

ps.setString(1, name);

ps.setString(2, password);

rs = ps.executeQuery();

if(rs.next())

{ 

userdbName = rs.getString("name");

userdbPsw = rs.getString("password");

dbUsertype = rs.getString("usertype");

if(name.equals(userdbName) && password.equals(userdbPsw))

{

session.setAttribute("name",userdbName);

response.sendRedirect("welcome.jsp"); 

} 

}

else

 response.sendRedirect("error.jsp");

 rs.close();

   ps.close(); 

}

catch(SQLException sqe)

{

out.println(sqe);

} 

}

else

{

%>

<center><p style="color:red">Error In Login</p></center>

<% 

getServletContext().getRequestDispatcher("/home.jsp").include(request, 
response);

}

%>

</body>

</html>