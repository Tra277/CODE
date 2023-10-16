<%-- 
    Document   : addCustomer
    Created on : Oct 14, 2023, 4:57:13 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
    </head>
    <body>
        <h1>Add your Customer</h1>
        <form action="../CustomerURL" method="post">
            <input type="hidden" name="service" value="insertCustomer"/>
            CustomerID:<input placeholder="String.." type="text" name="cid"><br/>
            Company name:<input type="text" name="companyName"><br/>
            Contact name::<input type="text" name="contactName"><br/>
            ContactTitle:<input type="text" name="contactTitle"><br/>
            Address:<input type="text" name="address"><br/>
            City:<input type="text" name="city"><br/>
            Region:<input type="text" name="region"><br/>

            PostalCode:<input type="text" name="postalCode"><br/>
            Country:<input type="text" name="country"><br/>
            Phone:<input type="text" name="phone"><br/>
            Fax<input type="text" name="fax"><br/>
            <input type="submit"  value="Submit">
            <input type="submit" name="reset" value="Reset">
        </form>
    </body>
</html>
