/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */ package controller; import java.awt.Color; import java.awt.Component; import java.sql.*; import java.io.IOException; import java.io.PrintWriter; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement; import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; import javax.swing.JLabel; import javax.swing.JOptionPane;

/** * * @author shuvo */ @WebServlet(name = "ControllerServlet", loadOnStartup = 1,
        urlPatterns = { 
            "/addProduct", 
            "/delete",
            "/login",
            "/home",
            "/logout",
            "/welcome",
            "/error",
            "/statistic", 
            "/updateInfo", 
            "/about"}) public class ControllerServlet extends HttpServlet {

/** * Processes requests for both HTTP <code>GET</code> and <code>POST</code> * methods. 
 * * @param request servlet request * @param response servlet response * @throws ServletException if a servlet-specific error occurs * @throws IOException if an I/O error occurs */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    { response.setContentType("text/html;charset=UTF-8"); 
    try (PrintWriter out = response.getWriter()) { 
        
        out.println("<!DOCTYPE html>"); out.println("<html>"); 
        out.println("<head>");
        out.println("<title>Servlet ControllerServlet</title>");
        out.println("</head>");
        out.println("<body>"); 
        out.println("<h1>Servlet ControllerServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>"); } }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code."> /** * Handles the HTTP <code>GET</code> method. * * @param request servlet request * @param response servlet response * @throws ServletException if a servlet-specific error occurs * @throws IOException if an I/O error occurs */ 
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    { String userPath = request.getServletPath();

// if category page is requested
if (userPath.equals("/statistic")) { 



} else if(userPath.equals("/delete")) {

} else if(userPath.equals("/login")) {

} else if(userPath.equals("/updateInfo")) {

}

String url = "/WEB-INF/view" + userPath + ".jsp";

try { request.getRequestDispatcher(url).forward(request, response); } catch (Exception ex) { ex.printStackTrace(); }

}

/** * Handles the HTTP <code>POST</code> method. * * @param request servlet request * @param response servlet response * @throws ServletException if a servlet-specific error occurs * @throws IOException if an I/O error occurs */ @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { String userPath = request.getServletPath();

if (userPath.equals("/login")) {

} else if (userPath.equals("/addProduct")) { //// to add PRODUCT

PrintWriter out=response.getWriter(); response.setContentType("text/plain");

String user_id,user_name,user_price,user_description,user_time,user_category;

user_name = request.getParameter("user_name").toString(); user_price = request.getParameter("user_price").toString(); user_description = request.getParameter("user_description").toString(); user_category = request.getParameter("user_category").toString(); System.out.println("workingggg");

try { String sql="insert into product values( '"+user_name+"','"+user_price+"','"+user_description+"','"+user_category+"' )"; Connection g=DriverManager.getConnection("jdbc:mysql://localhost/ecom", "root", "1212"); PreparedStatement ps=g.prepareStatement(sql);

ps.executeUpdate(); g.close();

// int result = ps.executeUpdate();

int result = ps.executeUpdate(); JLabel statusLabel = null; if (result == 0) { statusLabel.setForeground(Color.RED); statusLabel.setText("Error Inserting record"); } else { statusLabel.setForeground(Color.GREEN); statusLabel.setText("Insert Successful"); }

} catch(Exception e) { System.err.println("Error loading driver");

}

} else if (userPath.equals("/updateInfo")) {
} else if (userPath.equals("/delete")) {

}

// use RequestDispatcher to forward request internally 
String url = "/WEB-INF/view" + userPath + ".jsp";

try { request.getRequestDispatcher(url).forward(request, response); } catch (Exception ex) { ex.printStackTrace(); }

}

}

