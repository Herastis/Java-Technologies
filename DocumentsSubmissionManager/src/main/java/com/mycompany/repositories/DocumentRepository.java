/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repositories;

import com.mycompany.entities.Document;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
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

    //interceptor
    public void save(Document document) {
        Document documentEntiy = new Document();
        documentEntiy.setId(document.getId());
        documentEntiy.setName(document.getName());
        documentEntiy.setContent(document.getContent());
        documentEntiy.setRegistrationnumber(document.getRegistrationnumber());
        em.persist(documentEntiy);
    }

    public List<Document> getAll() {
        Query query = em.createNamedQuery("Document.getAll");
        return ((Collection<Document>) query.getResultList()).stream().collect(Collectors.toList());
    }

}
