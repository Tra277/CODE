<%-- 
    Document   : login
    Created on : Oct 1, 2023, 2:40:12 PM
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
        <h1>login form</h1>
        <%
        if(request.getAttribute("error")!=null){
            String err =(String)request.getAttribute("error");
        %>
        <h3 style="color:red"><%= (err)%></h3>
        <%
            }
        %>
        <form action="login" method="post">
            enter username:<input type="text" name="name"/><br/>
            enter password:<input type="password" name="pass"/><br/>
            <input type="submit" value="Submit"/>
            
        </form>
    </body>
</html>
