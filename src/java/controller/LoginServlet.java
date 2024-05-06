/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserDAO;

/**
 *
 * @author HELLO
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        username = username.trim();
        password = password.trim();

        if (username.isEmpty() || password.isEmpty()) {

            response.sendRedirect("login.jsp?error=Please enter both username and password");
            return;
        }

        try {

            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByUsername(username);

            System.out.println("Retrieved User: " + user);

            if (user != null && password.equals(user.getPassword().trim())) {
                request.getSession().setAttribute("user", user);

                response.sendRedirect("index.jsp");
            } else {

                response.sendRedirect("login.jsp?error=Invalid username or password");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            response.sendRedirect("login.jsp?error=An unexpected error occurred. Please try again later.");
        }

    }
}
