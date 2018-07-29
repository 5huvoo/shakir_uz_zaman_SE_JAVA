<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
  <head>

 < meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Confirming </title>

</head>

<body>

<%! String userdbName;

String userdbPsw;

String dbid;

%>

<%

PreparedStatement ps = null;

ResultSet rs = null;



String driverName = "com.mysql.jdbc.Driver";

String url = "jdbc:mysql://localhost:3306/ecom";

String user = "root";

String dbpsw = "1212";



String sql = "select * from admin where name=? and password=? and id=?";



String name = request.getParameter("name");
out.println(name);
String password = request.getParameter("password");

String id = request.getParameter("id");

out.println("before connection\n");


Class.forName(driverName);

Connection con = DriverManager.getConnection(url, user, dbpsw);

ps = con.prepareStatement(sql);

ps.setString(1, name);

ps.setString(2, password);

ps.setString(3, id);

rs = ps.executeQuery();

out.println("before connection\n");
if(rs.next())  { 

       userdbName = rs.getString("name");
       userdbPsw = rs.getString("password");
       dbid = rs.getString("id");

       
       if(name.equals(userdbName) && password.equals(userdbPsw) && id.equals(dbid))
          {
           // session.setAttribute("name",userdbName);
             //session.setAttribute("usertype", dbid); 
               response.sendRedirect("view/welcome.jsp"); 
            } 
               }
else {
        response.sendRedirect("error.jsp");
        rs.close();
        ps.close(); }


%>

</body>

</html>