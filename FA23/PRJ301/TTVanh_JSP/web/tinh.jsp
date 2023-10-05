<%-- 
    Document   : tinh
    Created on : Sep 24, 2023, 3:58:13 PM
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
        <h1>Bai tap 1:</h1>
        <form action="tinh" method="post">
            enter radius:<input type="text" name="radius"/><br/>
            <input type="submit" value="Calculate"/>
        </form>
        <%
            if(request.getAttribute("dt")!=null){
                double dt = (double) request.getAttribute("dt");
                //vi getAttribute no tra ve object nen can ep kieu ve double
        %>
        <h2>Dien tich la:<%= dt%></h2>
        <%
            }
        %>
    </body>
</html>
