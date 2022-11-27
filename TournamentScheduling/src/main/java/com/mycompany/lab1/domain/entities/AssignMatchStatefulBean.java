/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import repositories.MatchRepository;

/**
 *
 * @author ttomescu
 */
//2)A stateful session bean responsible with the assignment of one or more matches.
//The assignment should be atomic, either all matches are successfully scheduled, or the transaction will be rolled back.
@Stateful
@LocalBean
public class AssignMatchStatefulBean {

    @Inject
    MatchBean matchBean;

    @Inject
    List<MatchBean> matchListBean;

    @PersistenceContext(name = "MyPU")
    private EntityManager em;

    private List<MatchRepository> matchesRepository;

    @PostConstruct
    public void init() {
        matchesRepository = new ArrayList<>();
    }

    public void assignOneMatch() throws Exception {
        em.persist(matchBean);
        matchBean.save(100, 3, 1230, 1, 3);
    }

    public void assignMultipleMatches() throws Exception {

        for (int i = 0; i < matchListBean.size(); ++i) {
            MatchBean match = matchListBean.get(i);
            em.persist(match);
            match.save(100, 3, 1230, 1, 3);
        }
    }

    @Remove
    public void save() {
        System.out.println("Saving ... \n" + matchesRepository);
    }

}
