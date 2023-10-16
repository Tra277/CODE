<%-- 
    Document   : displaySupplier
    Created on : Oct 15, 2023, 8:51:02 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="model.DAOSupplier,entity.Supplier" %>
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
            Vector<Supplier> listSupplier = (Vector<Supplier>) request.getAttribute("data");
            String tableTitle = (String) request.getAttribute("tableTitle");
            String msg = (String) request.getAttribute("msg");
        %>
        <p><a href="JSP/addSupplier.jsp">Insert Supplier</a></p>
        <h1 style="font-family: fantasy;color: pink">Status:<%= msg %></h1>
        <table>
            <caption><%= tableTitle %></caption>
            <tr>
                <th>supplierID</th>
                <th>companyName</th>
                <th>contactName</th>
                <th>contactTitle</th>
                <th>address</th>
                <th>city</th>
                <th>region</th>
                <th>postalCode</th>
                <th>country</th>
                <th>phone</th>
                <th>fax</th>
                <th>homePage</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <% for(Supplier supplier : listSupplier){ %>
                <tr>
                            <td><%= supplier.getSupplierID() %></td>
                            <td><%= supplier.getCompanyName()%></td>
                            <td><%= supplier.getContactName()%></td>
                            <td><%= supplier.getContactTitle()%></td>
                            <td><%= supplier.getAddress()%></td>
                            <td><%= supplier.getCity()%></td>
                            <td><%= supplier.getRegion()%></td>
                            <td><%= supplier.getPostalCode()%></td>
                            <td><%= supplier.getCountry()%></td>
                            <td><%= supplier.getPhone()%> </td>
                            <td><%= supplier.getFax()%></td>
                            <td><%= supplier.getHomePage()%></td>
                            <td><a href="SupplierURL?service=updateSupplier&sid=<%=supplier.getSupplierID()%>">update</a></td>
                            <td><a href="SupplierURL?service=deleteSup&id=<%=supplier.getSupplierID()%>">delete</a></td>
                            </tr>
            <%}%>
        </table>
    </body>
</html>
