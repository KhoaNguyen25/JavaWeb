/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dbconnect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        ConnectDB db = ConnectDB.getInstance();

        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        ConnectDB db = ConnectDB.getInstance();

        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    user = new User(username, password, email);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
