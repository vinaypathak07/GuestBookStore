/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

/**
 *
 * @author Vinay Pathak
 */
public class Book {
   private String bookName;
   private String authorName;
   private int isbn;
   private String  description;
   public int noOfBooks;
    
   public Book(String bookName,String authorName,int isbn,String description){
       this.bookName = bookName ;
       this.authorName = authorName;
       this.isbn = isbn;
       this.description = description;
   }
    public int getNoOfbooks() {
        return noOfBooks;
    }

    public void setNoOfbooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
