/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositories;

import com.mycompany.entities.Document;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tomes
 */
public class DocumentRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Inject
    Instance<Integer> randomInt;

    int registrationNumber = randomInt.get();

    public void save(Document document) {
        Document documentEntiy = new Document();
        documentEntiy.setId(countDocuments() + 1);
        documentEntiy.setName(document.getName());
        documentEntiy.setContent(document.getContent());
        documentEntiy.setRegistrationnumber(registrationNumber);
        em.persist(documentEntiy);
    }

    public List<Document> getAll() {
        Query query = em.createNamedQuery("Document.getAll");
        return (List<Document>) (query.getResultList()).stream().collect(Collectors.toList());
    }

    public Document findById(int id) {
        Query query = em.createNamedQuery("Document.findById");
        query.setParameter("id", id);
        return (Document) query.getSingleResult();
    }

    public int countDocuments() {
        Query query = em.createNamedQuery("Document.countDocuments");
        return (int) query.getSingleResult();
    }

    public void remove(int id) {
        Document docToBeRemoved = findById(id);
        em.getTransaction().begin();
        em.remove(docToBeRemoved);
        em.getTransaction().commit();
    }

}
