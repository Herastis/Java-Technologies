/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

/**
 *
 * @author ttomescu
 */
public class TeamInfo {

    String name;
    String foundingDate;
    String city;

    public TeamInfo(String name, String foundingDate, String city) {
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
