/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import com.mycompany.lab1.domain.entities.MatchBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author ttomescu
 */
//3)A singleton session bean that keeps an in-memory map of the current assignments.
// The map will be instantiated at application startup and updated whenever the assignments change.
@Singleton
@Startup

public class CurrentAssignmentsSingletonBean implements Serializable {

    private HashMap<Integer, List<MatchBean>> mapCurrentAssignments;
    private int uniqueNumber;

    @Inject
    private MatchRepository matchRepo;

    @PostConstruct
    public void init() {
        // read the initial value of the number from DB
        uniqueNumber = 0;
    }

    @Lock
    public void updateMap() {
        uniqueNumber++;
        List<MatchBean> assignments = matchRepo.findAll();
        mapCurrentAssignments.put(uniqueNumber, assignments);
        System.out.println(mapCurrentAssignments);
    }

}
