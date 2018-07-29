<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> All Product </title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/ecom"
        user="root" password="1212"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM product;
    </sql:query>
     
    <div>
        <table border="1" cellpadding="1">
            <caption><h2> Products</h2></caption>
            <tr>
                
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                
                <th>Cateory</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                   
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.price}" /></td>
                    <td><c:out value="${user.description}" /></td>
                    
                    <td><c:out value="${user.category}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>