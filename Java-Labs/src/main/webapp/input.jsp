<%--
    Document   : input
    Created on : 16 Oct 2022, 16:31:21
    Author     : tomes
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%@ page import="java.util.Date" %>
    <%! String message = "Fill the form!";%>

    <body>
        <form action="controller">
            Word: <input type="text" name="word"/>
            Size: <input type="number" name="size"/>
            <input type="submit"/>
        </form>
        Page generated at: <%= new Date()%>
    </body>
</html>
