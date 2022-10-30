/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIInput;
import javax.inject.Named;

/**
 *
 * @author ttomescu
 */
@Named(value = "teamBean")
@SessionScoped
public class TeamBean implements Serializable {

    public UIInput getNameComponent() {
        return nameComponent;
    }

    public void setNameComponent(UIInput nameComponent) {
        this.nameComponent = nameComponent;
    }

    public UIInput getDateComponent() {
        return dateComponent;
    }

    public void setDateComponent(UIInput dateComponent) {
        this.dateComponent = dateComponent;
    }

    public UIInput getCityComponent() {
        return cityComponent;
    }

    public void setCityComponent(UIInput cityComponent) {
        this.cityComponent = cityComponent;
    }

    public ArrayList<TeamInfo> getList() {
        return list;
    }

    public void setList(ArrayList<TeamInfo> list) {
        this.list = list;
    }

    private UIInput nameComponent;
    private UIInput dateComponent;
    private UIInput cityComponent;

    private ArrayList<TeamInfo> list = new ArrayList<>();

    public void setTeamsInfoAll(ArrayList teamsInfoAll) {
        this.list = teamsInfoAll;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamBean{");
        sb.append("teamsInfoAll=").append(list);
        sb.append('}');
        return sb.toString();
    }

    public List getTeamsInfoAll() {
        return list;
    }

    @PostConstruct
    public void init() {
        System.out.println("asdksafksdaf");
        teamsService();
    }

    public void teamsService() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "ASD");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from teams");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                TeamInfo team = new TeamInfo(rs.getString(1), rs.getString(2),
                        rs.getString(3));
                list.add(team);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void nameComponentMethod() {
        nameComponent.setRendered(false);
    }

    public void dateComponentMethod() {
        dateComponent.setRendered(false);
    }

    public void cityComponenttMethod() {
        cityComponent.setRendered(false);
    }

}
