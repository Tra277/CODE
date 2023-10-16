<%-- 
    Document   : displayOrderDetail
    Created on : Oct 14, 2023, 10:55:48 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="model.DAOOrderDetail,entity.OrderDetail" %>
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
            Vector<OrderDetail> listOrderDetail = (Vector<OrderDetail>) request.getAttribute("data");
            String tableTitle = (String) request.getAttribute("tableTitle");
            String msg = (String) request.getAttribute("msg");
        %>
        <p><a href="OrderDetailURL?service=insertOrderDetail">Insert OrderDetail</a></p>
        <h1 style="font-family: fantasy;color: pink">Status:<%= msg %></h1>
        <table>
            <caption><%= tableTitle %></caption>
            <tr>
                <th>OrderId</th>
                <th>ProductId</th>
                <th>Unitprice</th>
                <th>Quantity</th>
                <th>Discount</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <% for(OrderDetail od : listOrderDetail){ %>
                <tr>
                            <td><%= od.getOrderID() %></td>
                            <td><%= od.getProductID()%></td>
                            <td><%= od.getUnitPrice()%></td>
                            <td><%= od.getQuantity()%></td>
                            <td><%= od.getDiscount()%></td>                            
                            <td><a href="OrderDetailURL?service=updateOrderDetail&oid=<%=od.getOrderID()%>&pid=<%=od.getProductID()%>">update</a></td>
                            <td><a href="OrderDetailURL?service=deleteOd&oid=<%=od.getOrderID()%>&pid=<%=od.getProductID()%>">delete</a></td>
                            </tr>
            <%}%>
        </table>
    </body>
</html>
