/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import model.BookDAO;

/**
 *
 * @author HELLO
 */
public class BookControllerServlet extends HttpServlet {

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
            out.println("<title>Servlet BookControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookControllerServlet at " + request.getContextPath() + "</h1>");
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
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST" ->
                    listBooks(request, response);
                case "ADD" ->
                    addBook(request, response);
                case "LOAD" ->
                    loadBook(request, response);
                case "UPDATE" ->
                    updateBook(request, response);
                case "DELETE" ->
                    deleteBook(request, response);
                case "SEARCH" ->
                    searchBooks(request, response);
                default ->
                    listBooks(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(BookControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {

        BookDAO bookDAO = new BookDAO();
        List<Book> list = bookDAO.getBooks();

        request.setAttribute("booklist", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-book.jsp");
        dispatcher.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String tenSach = request.getParameter("tenSach");
        String loaiSach = request.getParameter("loaiSach");
        float giaSach = Float.parseFloat(request.getParameter("giaSach"));

        Book book = new Book(tenSach, loaiSach, giaSach);

        BookDAO bookDAO = new BookDAO();
        bookDAO.addBook(book);

        response.sendRedirect("BookControllerServlet?command=LIST");
    }

    private void loadBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String theBookId = request.getParameter("bookId");

        Book book = new BookDAO().getBook(theBookId);

        request.setAttribute("THE_BOOK", book);

        RequestDispatcher dispatcher = request.getRequestDispatcher("update-book-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("bookId"));
        String tenSach = request.getParameter("tenSach");
        String loaiSach = request.getParameter("loaiSach");
        float giaSach = Float.parseFloat(request.getParameter("giaSach"));

        Book book = new Book(id, tenSach, loaiSach, giaSach);

        new BookDAO().updateBook(book);

        response.sendRedirect("BookControllerServlet?command=LIST");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String theBookId = request.getParameter("bookId");
        new BookDAO().deleteBook(theBookId);
        response.sendRedirect("BookControllerServlet?command=LIST");
    }

    private void searchBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String keyword = request.getParameter("search");

            BookDAO bookDAO = new BookDAO();
            List<Book> searchResults = bookDAO.searchBooks(keyword);

            request.setAttribute("booklist", searchResults);

            RequestDispatcher dispatcher = request.getRequestDispatcher("list-book.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BookControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
