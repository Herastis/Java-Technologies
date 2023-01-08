/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Document;
import com.mycompany.repositories.DocumentRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author tomes
 */
@Path("/documents")
@ApplicationScoped
public class DeleteDocumentService {

    @Inject
    private DocumentRepository documentRepository;

    //deleting an existing document.
    @DELETE
    @Path("/{id}")
    public Response deleteDocument(@PathParam("id") int id) {
        Document document = documentRepository.findById(id);
        if (document == null) {
            return Response.noContent().build();
        }
        documentRepository.remove(id);
        return Response.ok().entity("Document deleted!").build();
    }
}
