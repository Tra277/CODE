<%-- 
    Document   : addProduct
    Created on : Oct 9, 2023, 10:20:09 AM
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
        <h1>Add your product</h1>
        <% ResultSet rsCate = (ResultSet) request.getAttribute("rsCate");
           ResultSet rsSup = (ResultSet) request.getAttribute("rsSup");
        %>
        <form action="ProductURL" method="post">
            <input type="hidden" name="service" value="insertProduct">
            Product name:<input type="text" name="name"><br/>
            Supplier ID:
            <select name="supid">
                <%while(rsSup.next()){%>
                <option value="<%=rsSup.getInt(1)%>"><%=rsSup.getString(2)%></option>
                <%}%>
            </select><br/>
            Category ID:
            <select name="cateid">
                <%while(rsCate.next()){%>
                <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                <%}%>
            </select><br/>
            Quantity per unit:<input type="text" name="quantityPerUnit"><br/>
            UnitPrice:<input type="text" name="unitPrice"><br/>
            UnitsInStock:<input type="text" name="unitStock"><br/>
            UnitsOnOrder:<input type="text" name="unitOrder"><br/>
            ReorderLevel:<input type="text" name="reorder"><br/>
            Discontinued:<input type="radio" name="discontinued" value="0">discontinued
            <input type="radio" name="discontinued" value="1">continued<br/>
            <input type="submit" name="submit" value="Submit">
            <input type="submit" name="reset" value="Reset">
        </form>
    </body>
</html>
