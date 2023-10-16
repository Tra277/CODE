<%-- 
    Document   : login
    Created on : Oct 1, 2023, 2:40:12 PM
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
        <h1>login form</h1>
        <%
            if(request.getParameter("name")!=null && request.getParameter("pass")!=null){
                String username = request.getParameter("name");
                String pass = request.getParameter("pass");
                String username_save = request.getServletContext().getInitParameter("user");
                String pass_save = request.getServletContext().getInitParameter("pass");
                if(username.equalsIgnoreCase(username_save) && pass.equalsIgnoreCase(pass_save)){
                    //nhap dung
                    %>
                    <jsp:forward page="welcome.jsp">
                        <jsp:param name="name" value="<%= username_save %>"/>
                    </jsp:forward>
                    <%
                }else{
                    String er = "Ten dang nhap hoac mat khau sai!";
                    %>
                    <h3 style="color:red;"><%= er %></h3>
                    <%
                }
            }
            
        %>
        <form >
            enter username:<input type="text" name="name"/><br/>
            enter password:<input type="password" name="pass"/><br/>
            <input type="submit" value="Submit"/>
            
        </form>
    </body>
</html>
