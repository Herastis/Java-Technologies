/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.lab1.domain.entities.MatchBean;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ttomescu
 */
@Stateless
public class MatchRepository extends DataRepository<MatchBean, Integer> {

    @PersistenceContext
    private EntityManager em;

    public MatchRepository() {
        super(MatchBean.class);
    }

    public MatchBean findById(Integer integer) {
        return null;
    }

    public List<MatchBean> findAll() {
        Query query = em.createNamedQuery("Matches.findAll");
        List<MatchBean> matches = ((Collection<MatchBean>) query.getResultList()).stream().collect(Collectors.toList());
        return matches;
    }

    public List<MatchBean> findById() {
        Query query = em.createNamedQuery("Matches.findById");
        List<MatchBean> matches = ((Collection<MatchBean>) query.getResultList()).stream().collect(Collectors.toList());
        return matches;
    }

    public List<MatchBean> findByWeekday() {
        Query query = em.createNamedQuery("Matches.findByWeekday");
        List<MatchBean> matches = ((Collection<MatchBean>) query.getResultList()).stream().collect(Collectors.toList());
        return matches;
    }

    public List<MatchBean> findByPeriod() {
        Query query = em.createNamedQuery("Matches.findByPeriod");
        List<MatchBean> matches = ((Collection<MatchBean>) query.getResultList()).stream().collect(Collectors.toList());
        return matches;
    }

    public void updateEntities(List<MatchBean> entities) {
        for (MatchBean resource : entities) {
            save(resource);
        }
    }

    public void save(MatchBean matchesBean) {
        em.getTransaction().begin();
        em.persist(matchesBean);
        em.getTransaction().commit();
    }

//    public void create(MatchBean matchBean) {
//        em.persist(matchBean);
//    }
//
//      public void edit(MatchBean matchBean) {
//        em.persist(matchBean);
//    }
//
//    public void remove(MatchBean matchBean) {
//        em.persist(matchBean);
//    }
}
