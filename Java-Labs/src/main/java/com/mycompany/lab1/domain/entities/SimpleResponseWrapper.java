/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.domain.entities;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author tomes
 */
public class SimpleResponseWrapper
        extends HttpServletResponseWrapper {

    private final StringWriter output;

    public SimpleResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new StringWriter();
    }

    @Override
    public PrintWriter getWriter() {
        // Hide the original writer
        return new PrintWriter(output);
    }

    @Override
    public String toString() {
        return output.toString();
    }
}
