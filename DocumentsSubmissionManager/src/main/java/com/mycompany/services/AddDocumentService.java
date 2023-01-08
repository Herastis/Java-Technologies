/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Document;
import com.mycompany.repositories.DocumentRepository;
import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author tomes
 */
@Path("/documents")
@ApplicationScoped
public class AddDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    //adding a new document to the database;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDocument(Document document) {
        documentRepository.save(document);
        URI uri = UriBuilder.fromResource(this.getClass())
                .path("" + document.getId()).build();
        return Response.created(uri).entity(document).build();
    }
}
