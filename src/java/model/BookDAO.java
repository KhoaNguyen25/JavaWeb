package model;

import dbconnect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class BookDAO {

    public List<Book> getBooks() {
        List<Book> sl = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        String sql = "Select * from book";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tenSach = rs.getString(2);
                String loaiSach = rs.getString(3);
                float giaSach = rs.getFloat(4);
                Book book = new Book(id, tenSach, loaiSach, giaSach);
                sl.add(book);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO book (tensach, loaisach, giasach)\n"
                + "VALUES (?,?, ?);";
        ConnectDB db = ConnectDB.getInstance();

        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, book.getTenSach());
            statement.setString(2, book.getLoaiSach());
            statement.setFloat(3, book.getGiaSach());
            statement.execute();

            statement.close();
            con.close();

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateBook(Book book) {
        String sql = " UPDATE [VKUStudentDB].[dbo].[book]\n"
                + "SET tenSach=?, loaiSach=?, giaSach = ?\n"
                + "WHERE id = ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, book.getTenSach());
            statement.setString(2, book.getLoaiSach());
            statement.setFloat(3, book.getGiaSach());
            statement.setInt(4, book.getId());
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Book getBook(String idd) {
        List<Book> sl = new ArrayList<>();
        int id = Integer.parseInt(idd);
        ConnectDB db = ConnectDB.getInstance();
        Book book = null;
        String sql = "Select * from book where id=?";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                String tenSach = rs.getString(2);
                String loaiSach = rs.getString(3);
                Float giaSach = rs.getFloat(4);
                book = new Book(id, tenSach, loaiSach, giaSach);

            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }

    public void deleteBook(String idd) {
        // create the connection

        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnection();
            // prepare the statement in order to excute the sql comments
            String sql = "DELETE FROM book WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            // convert String id to int id
            int id = Integer.parseInt(idd);
            // set parameter in the sql
            statement.setInt(1, id);
            // execute the sql
            statement.execute();
            con.close();
            statement.close();

        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Book> searchBooks(String keyword) {
        List<Book> searchResult = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        String sql = "SELECT * FROM book WHERE tenSach LIKE ? OR loaiSach LIKE ? OR giaSach LIKE ?";
        try {
            Connection con = db.openConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            // Đặt tham số cho từ khóa tìm kiếm
            String searchPattern = "%" + keyword + "%";
            statement.setString(1, searchPattern);
            statement.setString(2, searchPattern);
            statement.setString(3, searchPattern);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tenSach = rs.getString(2);
                String loaiSach = rs.getString(3);
                Float giaSach = rs.getFloat(4);
                Book book = new Book(id, tenSach, loaiSach, giaSach);
                searchResult.add(book);
            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchResult;
    }

}
