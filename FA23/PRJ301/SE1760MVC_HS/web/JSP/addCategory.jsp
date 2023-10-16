<%-- 
    Document   : addCategory
    Created on : Oct 15, 2023, 2:03:58 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add your Category</h1>
        <form action="../CategoryURL" method="post">
            <input type="hidden" name="service" value="insertCategory"/>
            
            Category name:<input type="text" name="categoryName"><br/>
            Description:<input type="text" name="description"><br/>
            Picture:<input placeholder="Not avaible now... u can enter anything" type="text" name="picture"><br/>
            <input type="submit"  value="Submit">
            <input type="submit" name="reset" value="Reset">
        </form>
    </body>
</html>
