<%-- 
    Document   : updateCustomer
    Created on : Oct 14, 2023, 3:55:40 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<%@page import="java.util.Vector" %>
<%@page import="entity.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updateCustomer</title>
    </head>
    <body>
        <%
            Vector<Customer> vector=(Vector<Customer>)request.getAttribute("data");
            Customer customer = vector.get(0);
        %>
        <form action="CustomerURL" method="post">
            <input type="hidden" name="service" value="updateCustomer">
            CustomerID:<input readonly="" type="text" name="cid" value="<%=customer.getCustomerId()%>"/></br>                  
            Company name:<input type="text" name="companyName" value="<%=customer.getCompanyName()%>"><br/>
            Contact name::<input type="text" name="contactName" value="<%=customer.getContactName()%>"><br/>
            Contact Title:<input type="text" name="contactTitle" value="<%=customer.getContactTitle()%>"><br/>
            Address:<input type="text" name="address" value="<%=customer.getAddress()%>"><br/>
            City:<input type="text" name="city" value="<%=customer.getCity()%>"><br/>
            Region:<input type="text" name="region" value="<%=customer.getRegion()%>"><br/>

            PostalCode:<input type="text" name="postalCode" value="<%=customer.getPostalCode()%>"><br/>
            Country:<input type="text" name="country" value="<%=customer.getCountry()%>"><br/>
            Phone:<input type="text" name="phone" value="<%=customer.getPhone()%>"><br/>
            Fax:<input type="text" name="fax" value="<%=customer.getFax()%>"><br/>
            <input type="submit" name="submit" value="update Customer"/>
            <input type="reset" value="Clear">
    </body>
</html>
