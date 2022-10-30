/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.sql.*;
import java.util.*;

/**
 *
 * @author ttomescu
 */
public class TeamBean {

    private List teamsInfoAll = new ArrayList();

    public List getTeamInfoAll() {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgres://localhost:5432/postgres", "postgres", "ASD");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from teams");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                teamsInfoAll.add(i, new teamInfo(rs.getString(1), rs.getString(2),
                        rs.getString(3)));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return teamsInfoAll;
    }

    public class teamInfo {

        String name;
        String foundingDate;
        String city;

        public teamInfo(String name, String foundingDate, String city) {
            this.name = name;
            this.foundingDate = foundingDate;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getFoundingDate() {
            return foundingDate;
        }

        public String getCity() {
            return city;
        }
    }
}
