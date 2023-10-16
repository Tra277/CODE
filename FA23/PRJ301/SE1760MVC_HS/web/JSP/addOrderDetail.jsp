<%-- 
    Document   : addOrderDetail
    Created on : Oct 15, 2023, 8:41:19 AM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add your OrderDetail</h1>
        <% ResultSet rsOrder = (ResultSet) request.getAttribute("rsOrder");
           ResultSet rsPro = (ResultSet) request.getAttribute("rsPro");
        %>
        <form action="OrderDetailURL" method="post">
            <input type="hidden" name="service" value="insertOrderDetail">
            Order ID:
            <select name="oid">
                <%while(rsOrder.next()){%>
                <option value="<%=rsOrder.getInt(1)%>"><%=rsOrder.getInt(1)%></option>
                <%}%>
            </select><br/>
            Select Product:
            <select name="pid">
                <%while(rsPro.next()){%>
                <option value="<%=rsPro.getInt(1)%>"><%=rsPro.getString(2)%> (<%=rsPro.getInt(1)%>)</option>
                <%}%>
            </select><br/>
            unitPrice:<input placeholder="number..." type="text" name="unitPrice"><br/>
            quantity:<input placeholder="number..." type="text" name="quantity"><br/>
            discount:<input placeholder="number..." type="text" name="discount"><br/>
            
            <input type="submit" name="submit" value="Submit">
            <input type="submit" name="reset" value="Reset">
        </form>
    </body>
</html>
