<%-- 
    Document   : updateOrderDetail
    Created on : Oct 15, 2023, 9:38:34 AM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<%@page import="java.util.Vector" %>
<%@page import="entity.OrderDetail" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update OrderDetail</title>
    </head>
    <body>
        <%
            Vector<OrderDetail> vector=(Vector<OrderDetail>)request.getAttribute("data");
            OrderDetail od = vector.get(0);
        %>
        <form action="OrderDetailURL" method="post">
            <input type="hidden" name="service" value="updateOrderDetail">
            Order ID:
            <select name="oid">
                
                <option value="<%=od.getOrderID()%>"><%=od.getOrderID()%></option>
                
            </select><br/>
            Select Product:
            <select name="pid">
                
                <option value="<%=od.getProductID()%>"><%=od.getProductID()%></option>
                
            </select><br/>
            unitPrice:<input placeholder="number..." type="text" name="unitPrice" value="<%=od.getUnitPrice()%>"><br/>
            quantity:<input placeholder="number..." type="text" name="quantity" value="<%=od.getQuantity()%>"><br/>
            discount:<input placeholder="number..." type="text" name="discount" value="<%=od.getDiscount()%>"><br/>
            
            <input type="submit" name="submit" value="update OrderDetail"/>
            <input type="reset" value="Clear">
    </body>
</html>
