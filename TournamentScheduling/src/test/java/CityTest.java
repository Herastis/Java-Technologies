/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.lab1.domain.entities.CityBean;
import com.mycompany.lab1.domain.entities.TeamBean;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repositories.CityRepository;

/**
 *
 * @author ttomescu
 */
public class CityTest {

    long idMock = 3;
    String nameMock = "Vaslui";
    CityBean cityMock = new CityBean();
    List<CityBean> citiesMock = new ArrayList<CityBean>();
    CityRepository cityRepositoryMock = new CityRepository();

    public CityTest() {
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
                = Persistence.createEntityManagerFactory("poolResource");
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

    @Test
    public void FindAllTest() {
        List<CityBean> result = cityRepositoryMock.findAll();
        assertEquals(result, citiesMock);
    }

    @Test
    public void FindByCityIdTest() {
        CityBean result = cityRepositoryMock.findByCityid(idMock);
        assertNotNull(result);
    }

    @Test
    public void FindByNameTest() {
        CityBean result = cityRepositoryMock.findByName(nameMock);
        assertNotNull(result);
    }

    @Test
    public void CreateTest() {
        String createdCityName = cityMock.getName();
        cityRepositoryMock.create(cityMock);
        assertNotNull(cityRepositoryMock.findByName(createdCityName));
    }

    @Test
    public void EditTest() {
        cityMock.setName("Bucuresti");
        cityRepositoryMock.edit(cityMock);
        assertEquals("Bucuresti", cityMock.getName());
    }

    @Test
    public void RemoveTest() {
        String nameDeletedCity = cityMock.getName();
        cityRepositoryMock.remove(cityMock);
        assertNull(cityRepositoryMock.findByName(nameDeletedCity));
    }

}
