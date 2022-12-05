/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;

/**
 *
 * @author tomes
 */
@ApplicationScoped
public class NumberGenerator {

    private static final int MAX = 100;

    @Produces
    int getMaxNumber() {
        return MAX;
    }

    @Produces
    @Named
    int getRandomNumber() {
        return new Random().nextInt(100);
    }
}
