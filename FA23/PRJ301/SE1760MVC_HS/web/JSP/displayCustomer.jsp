<%-- 
    Document   : displayCustomer
    Created on : Oct 14, 2023, 3:54:57 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="model.DAOCustomer,entity.Customer" %>
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
            Vector<Customer> listCustomer = (Vector<Customer>) request.getAttribute("data");
            String tableTitle = (String) request.getAttribute("tableTitle");
            String msg = (String) request.getAttribute("msg");
        %>
        <p><a href="JSP/addCustomer.jsp">Insert Customer</a></p>
        <h1 style="font-family: fantasy;color: pink">Status:<%= msg %></h1>
        <table>
            <caption><%= tableTitle %></caption>
            <tr>
                <th>customerId</th>
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
                <th>update</th>
                <th>delete</th>
            </tr>
            <% for(Customer customer : listCustomer){ %>
                <tr>
                            <td><%= customer.getCustomerId() %></td>
                            <td><%= customer.getCompanyName()%></td>
                            <td><%= customer.getContactName()%></td>
                            <td><%= customer.getContactTitle()%></td>
                            <td><%= customer.getAddress()%></td>
                            <td><%= customer.getCity()%></td>
                            <td><%= customer.getRegion()%></td>
                            <td><%= customer.getPostalCode()%></td>
                            <td><%= customer.getCountry()%></td>
                            <td><%= customer.getPhone()%> </td>
                            <td><%= customer.getFax()%></td>
                            <td><a href="CustomerURL?service=updateCustomer&cid=<%=customer.getCustomerId()%>">update</a></td>
                            <td><a href="CustomerURL?service=deleteCus&id=<%=customer.getCustomerId()%>">delete</a></td>
                            </tr>
            <%}%>
        </table>
    </body>
</html>
