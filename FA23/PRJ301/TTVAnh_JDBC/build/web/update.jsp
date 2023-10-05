<%-- 
    Document   : update
    Created on : Oct 2, 2023, 9:20:30 AM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="model.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Update category</h1>
        <%
            if(request.getAttribute("category")!=null){
               Category c = (Category) request.getAttribute("category");
        %>
        <form action="update" method="post">
            ID:<input type="text" name="id" readonly value="<%= (c.getId()) %>"><br/>
            Name:<input type="text" name="name" value="<%= (c.getName()) %>"><br/>
            Describe:<input type="text" name="describe" value="<%= (c.getDescribe()) %>"><br/>
            <input type="submit" value="Update...">
        </form>
        <%   
            }
        %>

    </center>
</body>
</html>
