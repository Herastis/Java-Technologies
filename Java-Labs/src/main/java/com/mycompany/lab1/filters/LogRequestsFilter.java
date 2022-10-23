/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.mycompany.lab1.filters;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.FileHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
/**
 *
 * @author tomes
 */

import java.util.logging.SimpleFormatter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "LogRequestsFilter", urlPatterns = {"/input.jsp/*"})

public class LogRequestsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Logger logger = Logger.getLogger("Logger");
        String path = "F:\\Github\\Java-Technologies\\Java-Labs\\src\\main\\java\\com\\mycompany\\lab1\\logs\\log.log";

        try {
            File f = new File(path);
            if (!f.exists()) {
                f.createNewFile();
            }

            //Creating the fileHandler
            FileHandler fileHandler = new FileHandler(path, true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            //Log information regarding request
            logger.info(request.getMethod());
            logger.info(request.getRemoteAddr());
            logger.info(request.getRequestURI());
            logger.info(request.getCookies().toString());
            logger.info(request.getPathInfo());
            logger.info(request.getRequestedSessionId());
            logger.info(request.getLocale().toString());
            logger.info(new Date().toString());

            //close the handler
            fileHandler.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        chain.doFilter(req, res);
    }
}
