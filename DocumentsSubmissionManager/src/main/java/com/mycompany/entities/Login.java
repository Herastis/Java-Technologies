/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.dao.LoginDAO;
import java.io.IOException;
import java.io.Serializable;
import static java.rmi.server.LogStream.log;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author tomes
 */
@SessionScoped
@Named
public class Login implements Serializable {

    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    //validate login
    public String validateUsernamePassword() throws SQLException, IOException {
        boolean valid = LoginDAO.validate(username, password);
        System.out.println(valid);
        if (valid) {
            log("Login successful with credentials user: " + username + ", password: " + password);
            if (LoginDAO.isAdmin(username, password)) {
                System.out.println("forwarding to admin page");
                return "admin";
            } else {
                System.out.println("forwarding to user page");
                return "user";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
            return "index";
        }
    }

}
