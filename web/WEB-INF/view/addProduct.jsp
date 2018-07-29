<%-- 
    Document   : addproduct
    Created on : Jul 29, 2018, 12:21:49 PM
    Author     : shuvo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product Page</title>
    </head>
    <body>
        <form action="addcontroller" method="POST">
        <table>
            <tr>
                <th>Name</th>
                <td><input type="text" name="user_name"    </td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="text" name="user_price"    </td>
            </tr>
            <tr>
                <th>Description</th>
                <td><input type="text" name="user_description"    </td>
            </tr>
            <tr>
                <th>Category</th>
                <td><input type="text" name="user_category"    </td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" name="submit"  value="submit"  </td>
            </tr>
            
        </table> 
        </form>
        
        
    </body>
</html>
