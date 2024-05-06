/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import model.BookDAO;
import java.util.List;
import model.Book;

/**
 *
 * @author HP
 */
public class TestDB {
    public static void  main(String[] args){
        BookDAO bookDAO = new BookDAO();
        List<Book> l = bookDAO.getBooks();
        System.out.println(""+l);
    }
    
}
