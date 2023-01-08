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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author tomes
 */
@Path("/documents")
@ApplicationScoped
public class ReplaceDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    //replacing an existing document;
    @PUT
    @Path("/{id}")
    public Response replaceDoc(@PathParam("id") int id, @QueryParam("name") String name) {
        Document document = documentRepository.findById(id);
        if (document != null) {
            document.setName(name);
            documentRepository.save(document);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
