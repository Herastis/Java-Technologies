/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Document;
import com.mycompany.repositories.DocumentRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tomes
 */
@Path("/uploaded-documents")
@ApplicationScoped
public class GetUploadedDocumentsService {

    @Inject
    private DocumentRepository documentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public List<Document> getall() {
        return documentRepository.getAll();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> findByUserId(@PathParam("userId") int id) {
        return documentRepository.getAll().stream().filter(d -> d.getUserid().equals(id)).collect(Collectors.toList());
    }
}
