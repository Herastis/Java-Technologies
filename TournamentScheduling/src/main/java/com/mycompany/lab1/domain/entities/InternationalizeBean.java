/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.beans.*;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ttomescu
 */
@Named(value = "internationalizeBean")
@SessionScoped
public class InternationalizeBean implements Serializable {

    Locale locale = Locale.getDefault();

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void changeLocale() {
        if (this.locale.getLanguage().equals("ro")) {
            this.locale = new Locale("en");
        } else {
            this.locale = new Locale("ro");
        }
    }

}
