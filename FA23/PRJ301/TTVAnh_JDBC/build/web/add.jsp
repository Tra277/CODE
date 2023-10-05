<%-- 
    Document   : add
    Created on : Oct 1, 2023, 10:13:45 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Add new category</h1>
            <%
                String err = "";
                if(request.getAttribute("error")!=null){
                    err = (String)request.getAttribute("error");
                }
            %>
            <h3 style="color: red"><%=(err)%></h3>
            <form action="add">
                ID:<input type="text" name="id"><br/>
                Name:<input type="text" name="name"><br/>
                Describe:<input type="text" name="describe"><br/>
                <input type="submit" value="ADD">
            </form>
        </center>
    </body>
</html>
