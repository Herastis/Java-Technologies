/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.lab1.domain.entities.TeamBean;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ttomescu
 */
@Stateless
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    public List<TeamBean> findAll() {
        return em.createNamedQuery("Teams.findAll")
                .getResultList();
    }

    public TeamBean findByFoundingdate(Date foundingDate) {
        return (TeamBean) em.createNamedQuery("Teams.findByFoundingdate")
                .setParameter("foundingDate", foundingDate)
                .getSingleResult();
    }

    public TeamBean findByName(String name) {
        return (TeamBean) em.createNamedQuery("Teams.findByName")
                .setParameter("name", name)
                .getSingleResult();
    }

    public TeamBean findById(Long id) {
        return (TeamBean) em.createNamedQuery("Teams.findById")
                .setParameter("id", id)
                .getSingleResult();
    }

    public void create(TeamBean teambean) {
        em.persist(teambean);
    }

    public void edit(TeamBean teambean) {
        em.persist(teambean);
    }

    public void remove(TeamBean teambean) {
        em.persist(teambean);
    }
}
