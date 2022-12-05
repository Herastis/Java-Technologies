/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import com.mycompany.logging.Logger;
import com.mycompany.logging.Logging;
import com.mycompany.logging.MyInterceptor;
import com.mycompany.repositories.DocumentRepository;
import static java.rmi.server.LogStream.log;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author tomes
 */
@Named
@Logger
public class DocumentsList {

    Calendar calendar = Calendar.getInstance();

    private List<Document> documents;
    @EJB
    private DocumentRepository documentRepo;

    @Inject
    Document document;

    @PostConstruct
    public void init() {
        documents = documentRepo.getAll();
    }

    protected @Inject
    Event<Document> eventDoc;

    @Interceptors(MyInterceptor.class)
    public void checkSubmissionAvailability(Document document) {
        Logging log = new Logging();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 8 && hour <= 18) {
            documentRepo.save(document);
            eventDoc.fire(document);
            log.log("Document submitted successfully");
        } else {
            log.log("Can't submit document now. Try later!");
        }
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void documentAddNotification(@Observes Document doc) {
        Logging log = new Logging();
        log.log("A new document has been added!");
    }
}
