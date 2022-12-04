/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author tomes
 */
public class LoginDAO {

    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usernameDB = "postgres";
        String passwordDB = "asd";

        try {
            con = DriverManager.getConnection(url, usernameDB, passwordDB);
            ps = con.prepareStatement("Select u.username, u.password from User u where u.username = ? and u.password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error --> " + ex.getMessage());
            return false;
        }
//        finally {
//            DataConnect.close(con);
//        }
        return false;
    }

    public static boolean isAdmin(String user, String pwd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
