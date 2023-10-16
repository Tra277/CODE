<%-- 
    Document   : updateCategory
    Created on : Oct 15, 2023, 2:42:09 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<%@page import="java.util.Vector" %>
<%@page import="entity.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Category</title>
    </head>
    <body>
        <%
            Vector<Category> vector=(Vector<Category>)request.getAttribute("data");
            Category category = vector.get(0);
        %>
        <form action="CategoryURL" method="post">
            <input type="hidden" name="service" value="updateCategory">
            CategoryID:<input readonly="" type="text" name="cid" value="<%=category.getCategoryID()%>"/></br>                  
            Category name:<input type="text" name="categoryName" value="<%=category.getCategoryName()%>"><br/>
            Description:<input type="text" name="description" value="<%=category.getDescription()%>"><br/>
            Picture:<input placeholder="Not avaible now... u can enter anything" type="text" name="picture" value="<%=category.getPicture()%>"><br/>
            
            <input type="submit" name="submit" value="update Category"/>
            <input type="reset" value="Clear">
    </body>
</html>
