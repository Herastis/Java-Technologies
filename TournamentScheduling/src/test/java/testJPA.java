/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.lab1.domain.entities.CityBean;
import com.mycompany.lab1.domain.entities.TeamBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ttomescu
 */
public class testJPA {

    public testJPA() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testJPA() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        TeamBean teams = new TeamBean();
        teams.setName("FC Vaslui");
        em.persist(teams);

        teams = (TeamBean) em.createQuery(
                "select e from Teams e where e.name='FC Vaslui'")
                .getSingleResult();
        teams.setName("Baz");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
