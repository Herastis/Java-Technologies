/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.mycompany.lab1.filters;

import com.mycompany.lab1.domain.entities.SimpleResponseWrapper;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomes
 */
@WebFilter(filterName = "ResponseDecorator", urlPatterns = {"/*"})
public class ResponseDecoratorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        SimpleResponseWrapper wrapper
                = new SimpleResponseWrapper((HttpServletResponse) response);

        //Send the decorated object as a replacement for the original response
        chain.doFilter(request, wrapper);

        //Get the dynamically generated content from the decorator and modify the content
        //Add at the beginning
        String content = "Prelude: Some text" + wrapper.toString();

        //Add at the end
        content += "Coda: Some text";

        //Send the modified content using the original response
        PrintWriter out = response.getWriter();

        out.write(content);
    }
}
