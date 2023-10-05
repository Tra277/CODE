<%-- 
    Document   : list
    Created on : Sep 28, 2023, 5:25:00 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of student</h1>
        <table border="1px">
            <tr>
                <th>ID:</th>
                <th>Name:</th>
                <th>Dob:</th>
                <th>Gender</th>
            </tr>

            <% 
                List<Student> list =(List<Student>)request.getAttribute("data");
                if (list != null) {
                    for(Student i :list){
            %>
            <tr>
                <td><%= i.getId()%></td>
                <td><%= i.getName()%></td>
                <td><%= i.getDob()%></td>
                <td><%= i.isGender()%></td>
                <td>
                    <img <%= (i.isGender()?"src='images/male.png'":"src='images/female.png'") %> width="30px" height="30px"/>
                </td>
            </tr>
            <%    
                    }
                }
            %>  


        </table>
    </body>
</html>
