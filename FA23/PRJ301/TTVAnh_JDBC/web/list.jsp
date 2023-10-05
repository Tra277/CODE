<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="model.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id){
                if(confirm("are u sure to delete category with ID=" + id)){
                    window.location="delete?id="+id;
                }
            }
        </script>
    </head>
    <body>
    <center>
        <h1>List of category!</h1>
        <h3><a href="add.jsp">Add new</a></h3>
        <table border="1px" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>describe</th>
                <th>CRUD action</th>
            </tr>
            <%
            if(request.getAttribute("data")!=null){
                List<Category> list = (List<Category>)request.getAttribute("data");
                for(Category c: list){
            %>
            <tr>
                <td><%= (c.getId())%></td>
                <td><%= (c.getName())%></td>
                <td><%= (c.getDescribe())%></td>
                <td>
                    <a href="update?id=<%= (c.getId()) %>">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#" onclick="doDelete('<%= (c.getId())%>')">Delete</a>
                </td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </center>        
    </body>
</html>
