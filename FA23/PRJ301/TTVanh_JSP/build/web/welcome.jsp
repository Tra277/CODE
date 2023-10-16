<%-- 
    Document   : welcome
    Created on : Oct 1, 2023, 3:03:57 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("name")!=null){
                String name = request.getParameter("name");
        %>
        <h1>Hello <%=(name)%></h1>
        <%
            }
        
        %>
        
    </body>
</html>
