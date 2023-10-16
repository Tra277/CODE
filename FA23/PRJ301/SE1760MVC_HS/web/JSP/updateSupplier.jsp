<%-- 
    Document   : updateSupplier
    Created on : Oct 15, 2023, 9:33:20 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<%@page import="java.util.Vector" %>
<%@page import="entity.Supplier" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update Supplier</title>
    </head>
    <body>
        <%
            Vector<Supplier> vector=(Vector<Supplier>)request.getAttribute("data");
            Supplier supplier = vector.get(0);
        %>
        <form action="SupplierURL" method="post">
            <input type="hidden" name="service" value="updateSupplier">
            SupplierID:<input readonly="" type="text" name="sid" value="<%=supplier.getSupplierID()%>"/></br>                  
            Company name:<input type="text" name="companyName" value="<%=supplier.getCompanyName()%>"><br/>
            Contact name::<input type="text" name="contactName" value="<%=supplier.getContactName()%>"><br/>
            Contact Title:<input type="text" name="contactTitle" value="<%=supplier.getContactTitle()%>"><br/>
            Address:<input type="text" name="address" value="<%=supplier.getAddress()%>"><br/>
            City:<input type="text" name="city" value="<%=supplier.getCity()%>"><br/>
            Region:<input type="text" name="region" value="<%=supplier.getRegion()%>"><br/>

            PostalCode:<input type="text" name="postalCode" value="<%=supplier.getPostalCode()%>"><br/>
            Country:<input type="text" name="country" value="<%=supplier.getCountry()%>"><br/>
            Phone:<input type="text" name="phone" value="<%=supplier.getPhone()%>"><br/>
            Fax:<input type="text" name="fax" value="<%=supplier.getFax()%>"><br/>
            Home Page:<input type="text" name="fax" value="<%=supplier.getHomePage()%>"><br/>
            <input type="submit" name="submit" value="update Supplier"/>
            <input type="reset" value="Clear">
    </body>
</html>
