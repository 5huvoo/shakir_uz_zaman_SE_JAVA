/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JLabel;

/**
 *
 * @author shuvo
 */
@WebServlet(name = "addcontroller", urlPatterns = {"/addcontroller"})
public class addcontroller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addcontroller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addcontroller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       response.setContentType("text/plain");
           
       String user_id,user_name,user_price,user_description,user_time,user_category;    
        
       user_name = request.getParameter("user_name").toString();
       user_price = request.getParameter("user_price").toString();
       user_description = request.getParameter("user_description").toString();
       user_category = request.getParameter("user_category").toString();
    
    
       
          
            
         try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ecom", "root", "1212")) {
             PreparedStatement    ps = null;
             System.out.println("hhehe");
             
             String sql=
                     ("insert into product values(?,?,?,?)");
             ps.setString(1, user_name);
             ps.setString(2, user_price);
             ps.setString(3, user_description);
             ps.setString(4, user_category);
             
             ps=conn.prepareStatement(sql);
             ps.executeUpdate();
         }
       
           
        
        catch(Exception   e)
        {
         System.err.println("Error loading driver");
                  
        } 


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
