/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositories;

import com.mycompany.entities.UserBean;
import com.mycompany.interfaces.SubmissionAvailability;
import com.mycompany.logging.Logger;
import com.mycompany.logging.Logging;
import com.mycompany.logging.MyInterceptor;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author tomes
 */
@Transactional(rollbackOn = {SQLException.class})
@Named
@Logger
public class UserRepository implements SubmissionAvailability {

    Calendar calendar = Calendar.getInstance();

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    //interceptor
    @Interceptors(MyInterceptor.class)
    @Override
    public void save(UserBean user) {
        UserBean userEntiy = new UserBean();
        userEntiy.setId(countUsers() + 1);
        userEntiy.setName(user.getName());
        userEntiy.setRole(user.getRole());
        userEntiy.setUsername(user.getUsername());
        userEntiy.setPassword(user.getPassword());
        em.persist(userEntiy);
    }

    public void checkSubmissionAvailability(UserBean user) {
        Logging log = new Logging();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 8 && hour <= 18) {
            save(user);
            log.log("User saved");
        } else {
            log.log("Can't register user now. Try later!");
        }
    }

    public int countUsers() {
        Query query = em.createNamedQuery("Document.countUsers");
        return (int) query.getSingleResult();
    }
}
