/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.config;

import com.mycompany.services.AddDocumentService;
import com.mycompany.services.DeleteDocumentService;
import com.mycompany.services.GetUploadedDocumentsService;
import com.mycompany.services.ReplaceDocumentService;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author tomes
 */
@ApplicationPath("/resources")
@ApplicationScoped
public class ApplicationConfig {

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(AddDocumentService.class);
        resources.add(DeleteDocumentService.class);
        resources.add(GetUploadedDocumentsService.class);
        resources.add(ReplaceDocumentService.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}
