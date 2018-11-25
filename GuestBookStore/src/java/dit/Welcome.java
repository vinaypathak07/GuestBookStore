/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Vinay Pathak
 */
public class Welcome extends HttpServlet {

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
            ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("books");
            String html1 = "\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "        <title>JSP Page</title>\n"
                    + "        <link rel=\"stylesheet\" href=\"style.css\">"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n"
                    + "    </head>\n"
                    + "    <body> \n"
                    + "        <div class=\"container-fluid \"> \n"
                    + "            <div class=\"row\">\n"
                    + "                 <div class=\"col-sm-4\">\n"
                    + "                     <p id=\"para1\">Add New Book To Store</p>\n"
                    + "                     <form action=\"GuestBook\">\n"
                    + "                        <p>Enter Book Name*</p>\n"
                    + "                        <input type=\"text\" name=\"t1\" placeholder=\"Enter Book Name*\" required=\"required\"><br><br>\n"
                    + "                        <p>Enter Author Name*</p>\n"
                    + "                        <input type=\"text\" name=\"t2\" placeholder=\"Enter Author Name*\" required=\"required\"><br><br>\n"
                    + "                        <p>Enter ISBN*</p>\n"
                    + "                        <input type=\"text\" name=\"t3\" placeholder=\"Enter ISBN*\" required=\"required\"><br><br>\n"
                    + "                        <p>Enter Description*</p>\n"
                    + "                        <textarea name=\"t4\" required=\"required\">Enter Description Here...</textarea><br><br>\n"
                    + "                        <input type=\"submit\" value=\"Add Book\"> \n"
                    + "                        <button id=\"b1\" formaction=\"UpdateBook\">Update Book</button>\n"
                    + "                     </form>\n"
                    + "                 </div>\n"
                    + "                 <div class=\"col-sm-7\">\n"
                    + "                      <p>Guest Book Entries</p>\n"
                    + "                        <table>\n"
                    + "                            <thead id=\"id1\">\n"
                    + "                                <tr>\n"
                    + "                                    <th>Book Name</th>\n"
                    + "                                    <th>Author Name</th>\n"
                    + "                                    <th>ISBN</th>\n"
                    + "                                    <th>Description</th>\n"
                    + "                                    <th>Delete Book</th>"
                    + "                                </tr>\n"
                    + "                            </thead>\n"
                    + "                            <tbody> \n";
            out.print(html1);
            for (Book book : list) {
                out.print("                                 <tr>\n");
                out.print("                                    <td>" + book.getBookName() + "</td>\n");
                out.print("                                    <td>" + book.getAuthorName() + "</td>\n");
                out.print("                                    <td>" + book.getIsbn() + "</td>\n");
                out.print("                                    <td>" + book.getDescription() + "</td>\n");
                out.print("                                    <td><form action=\"DeleteBook\">\n");
                out.print("                                                <button id=\"f1\" name=\"t5\" value=\"" + book.getIsbn() + "\">Delete</button>\n");
                out.print("                                            </form>\n");
                out.print("                                        </td>");
                out.print("                                   </tr>\n");
            }
            String html2 = "             </tbody>\n"
                    + "                        </table><br><br>\n"
                    + "                        <form action=\"FetchBook\">\n"
                    + "                           <button id=\"f2\">Fetch Entries</button>\n"
                    + "                           </form>\n"
                    + "                  </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n";
            out.print(html2);
        } catch (Exception e) {
            e.printStackTrace();
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
