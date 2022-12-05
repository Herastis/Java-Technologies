/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositories;

import com.mycompany.entities.UserBean;
import com.mycompany.interfaces.SubmissionAvailability;
import java.util.Calendar;
import java.util.Date;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author tomes
 */
@Decorator
public abstract class UserRepositoryDecorator implements SubmissionAvailability {

    @Inject
    @Delegate
    @Any
    SubmissionAvailability submissionInterface;

    @Override
    public void save(UserBean user) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 8 && hour <= 18) {
            System.out.println("Available submission time");
        }
    }
}
