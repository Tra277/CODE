<%-- 
    Document   : addSupplier
    Created on : Oct 15, 2023, 9:18:19 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add Supplier</title>
    </head>
    <body>
        <h1>Add your Supplier</h1>
        <form action="../SupplierURL" method="post">
            <input type="hidden" name="service" value="insertSupplier"/>
            Company name:<input type="text" name="companyName"><br/>
            Contact name:<input type="text" name="contactName"><br/>
            Contact Title:<input type="text" name="contactTitle"><br/>
            Address:<input type="text" name="address"><br/>
            City:<input type="text" name="city"><br/>
            Region:<input type="text" name="region"><br/>

            PostalCode:<input type="text" name="postalCode"><br/>
            Country:<input type="text" name="country"><br/>
            Phone:<input type="text" name="phone"><br/>
            Fax:<input type="text" name="fax"><br/>
            HomePage:<input type="text" name="homePage"><br/>
            <input type="submit"  value="Submit">
            <input type="submit" name="reset" value="Reset">
        </form>
    </body>
</html>
