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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ttomescu
 */
//1)A stateless session bean that offers methods for
//checking the availability of a period in a week.
@Stateless
public class CheckPeriodAvailabilityRepository extends DataRepository<MatchBean, Integer> {

    @PersistenceContext
    private EntityManager em;

    public CheckPeriodAvailabilityRepository() {
        super(MatchBean.class);
    }

    //check availability of a period in a week
    public List<MatchBean> checkPeriodInWeek(int period, int week) {
        Query query = em.createNamedQuery("Matches.checkPeriodInWeek")
                .setParameter("period", period)
                .setParameter("week", week);
        List<MatchBean> matches = ((Collection<MatchBean>) query.getResultList()).stream().collect(Collectors.toList());
        return matches;
    }
}
