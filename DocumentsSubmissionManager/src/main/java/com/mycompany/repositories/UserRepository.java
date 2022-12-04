/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositories;

import com.mycompany.entities.UserBean;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author tomes
 */
@Transactional(rollbackOn = {SQLException.class})
@Named
public class UserRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    //interceptor
    public void save(UserBean user) {
        UserBean userEntiy = new UserBean();
//        userEntiy.setId(10);
//        userEntiy.setName(user.getName());
        userEntiy.setRole(user.getRole());
        userEntiy.setUsername(user.getUsername());
        userEntiy.setPassword(user.getPassword());
        em.persist(userEntiy);
    }

    public void checkTimeFrame(UserBean user) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour <= 24 && hour >= 8) {
            save(user);
            System.out.println("User saved");
        } else {
            System.out.println("Can't register at this time. Try later!");
        }
    }
}
