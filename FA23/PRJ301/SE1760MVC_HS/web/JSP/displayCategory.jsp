<%-- 
    Document   : displayCategory
    Created on : Oct 15, 2023, 1:53:27 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="model.DAOCategory,entity.Category" %>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
    <head>
        <%
        String pageTitle = (String) request.getAttribute("pageTitle");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= pageTitle %></title>
    </head>
    <body>
        <%
            Vector<Category> listCategory = (Vector<Category>) request.getAttribute("data");
            String tableTitle = (String) request.getAttribute("tableTitle");
            String msg = (String) request.getAttribute("msg");
        %>
        <p><a href="JSP/addCategory.jsp">Insert Category</a></p>
        <h1 style="font-family: fantasy;color: pink">Status:<%= msg %></h1>
        <table>
            <caption><%= tableTitle %></caption>
            <tr>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Description</th>
                <th>Picture</th>                
                <th>update</th>
                <th>delete</th>
            </tr>
            <% for(Category category : listCategory){ %>
                <tr>
                            <td><%= category.getCategoryID() %></td>
                            <td><%= category.getCategoryName()%></td>
                            <td><%= category.getDescription()%></td>
                            <td>[image]</td>                            
                            <td><a href="CategoryURL?service=updateCategory&id=<%=category.getCategoryID()%>">update</a></td>
                            <td><a href="CategoryURL?service=deleteCategory&id=<%=category.getCategoryID()%>">delete</a></td>
                            </tr>
            <%}%>
        </table>
    </body>
</html>
