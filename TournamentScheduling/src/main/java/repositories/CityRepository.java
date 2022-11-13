/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.lab1.domain.entities.CityBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ttomescu
 */
@Stateless
public class CityRepository {

    @PersistenceContext
    private EntityManager em;

    public List<CityBean> findAll() {
        return em.createNamedQuery("Cities.findAll")
                .getResultList();
    }

    public CityBean findByCityid(Long id) {
        return (CityBean) em.createNamedQuery("Cities.findByCityid")
                .setParameter("cityId", id)
                .getSingleResult();
    }

    public CityBean findByName(String name) {
        return (CityBean) em.createNamedQuery("Cities.findByName")
                .setParameter("name", name)
                .getSingleResult();

    }

    public void create(CityBean cityBean) {
        em.persist(cityBean);
    }

    public void edit(CityBean cityBean) {
        em.persist(cityBean);
    }

    public void remove(CityBean cityBean) {
        em.persist(cityBean);
    }
}
