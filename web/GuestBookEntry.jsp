<%-- 
    Document   : GuestBookEntry
    Created on : Nov 20, 2018, 10:41:59 PM
    Author     : Vinay Pathak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body> 
        <div class="container-fluid "> 
            <div class="row">
                 <div class="col-sm-4">
                     <p id="para1">Add New Book To Store</p>
                     <form action="GuestBook">
                        <p>Enter Book Name*</p>
                        <input type="text" name="t1" placeholder="Enter Book Name*" required="required"><br><br>
                        <p>Enter Author Name*</p>
                        <input type="text" name="t2" placeholder="Enter Author Name*" required="required"><br><br>
                        <p>Enter ISBN*</p>
                        <input type="text" name="t3" placeholder="Enter ISBN*" required="required"><br><br>
                        <p>Enter Description*</p>
                        <textarea name="t4" required="required">Enter Description Here...</textarea><br><br>
                        <input type="submit" value="Add Book">
                        <button id="b1" formaction="UpdateBook">Update Book</button>
                     </form>
                 </div>
                 <div class="col-sm-7">
                      <p>Guest Book Entries</p>
                        <table>
                            <thead id="id1">
                                <tr>
                                    <th>Book Name</th>
                                    <th>Author Name</th>
                                    <th>ISBN</th>
                                    <th>Description</th>
                                    <th>Delete Book</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach items="${books}" var="book">
                                   <tr>
                                        <td>${book.getBookName()} </td>
                                        <td>${book.getAuthorName()} </td>
                                        <td>${book.getIsbn()} </td>
                                        <td>${book.getDescription()}</td>
                                        <td><form action="DeleteBook">
                                                <button  id="f1" name="t5" value="${book.getIsbn()}">Delete</button>
                                            </form>
                                        </td>
                                   </tr>
                                </c:forEach>   
                            </tbody>
                        </table>
                        <br><br>
                        <form action="FetchBook">   
                            <button id="f2">Fetch Entries</button>
                        </form>        
                  </div>   
            </div>   
        </div>
    </body>
</html>
