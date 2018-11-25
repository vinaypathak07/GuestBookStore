/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dit.Book;

/**
 *
 * @author Vinay Pathak
 */
public class GuestBook extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            
            String bookName = request.getParameter("t1");
            String  authorName= request.getParameter("t2");
            int isbn = Integer.parseInt(request.getParameter("t3"));
            String description = request.getParameter("t4");
            
            Book bk = new Book(bookName,authorName,isbn,description);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_f", "root", "admin123");
            PreparedStatement pst = con.prepareStatement("insert into guest_book values(?,?,?,?);");   
            pst.setString(1,bookName);
            pst.setString(2,authorName);
            pst.setInt(3,isbn);
            pst.setString(4,description);
            int status = pst.executeUpdate();
            
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("select COUNT(*) from guest_book;");
            while(rs.next()){
                bk.setNoOfbooks(rs.getInt(1));
            }
            if(status>0){
                System.out.println("Book Added "+bk.getNoOfbooks());
            }
            else{
                System.out.println("Fail To Add The Book");
            }      
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GuestBook</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuestBook at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            response.sendRedirect("FetchBook");
        }
        catch(Exception e){
            out.println(e.getMessage());
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
        processRequest(request, response);
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
